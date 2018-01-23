import java.util.Arrays;

/**
 * ���鼯ʵ�ֽ������Ȧ���� ������֪��n���˺�m�Ժ��ѹ�ϵ����������r���������������ֱ�ӻ��ӵĺ��ѣ����ѵĺ��ѵĺ��ѡ���������Ϊ��������ͬһ������Ȧ��
 * ��д���������n������һ���ж��ٸ�����Ȧ�� ���磺n = 5��m = 3��r = {{1 , 2} , {2 , 3} , {4 ,
 * 5}}����ʾ��5���ˣ�1��2�Ǻ��ѣ�2��3�Ǻ��ѣ�4��5�Ǻ��ѣ���1��2��3����һ������Ȧ��4��5������һ������Ȧ�����Ϊ2������Ȧ��
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2 }, { 2, 4 }, { 3, 5 }, { 5, 6 }, { 4, 7 }, { 9, 8 }, { 8, 9 } };
		int n = 9;
		int m = 7;
		Solution solution = new Solution();
		System.out.println(solution.friends(arr, n, m));
	}

	public int friends(int[][] arr, int n, int m) {
		UnionSet unionSet = new UnionSet(n);
		for (int i = 1; i < m; ++i) {
			unionSet.union(arr[i][0], arr[i][1]);
		}
		return unionSet.countRoot();
	}
}

class UnionSet {
	/**
	 * 
	 * @param n
	 *            �� n����
	 */
	int n;
	int[] parents;

	public UnionSet(int n) {
		this.n = n;
		parents = new int[n + 1];
		/*
		 * �ȳ�ʼ��ÿ���˵�������-1
		 */
		Arrays.fill(parents, -1);
	}

	/* ����ĳһ������Ȧ���ڵ� */
	public int find(int index) {
		int root = index;
		/*parents[root] > 0��ʾ���и��ڵ�*/
		while (parents[root] > 0) {
			root = parents[root];
		}
		return root;
	}

	/* �������ѵĹ�ϵ */
	public void union(int r1, int r2) {
		int root1 = find(r1);
		int root2 = find(r2);
		/*r1��r2û�й�ͬ����*/
		if (root1 != root2) {
			parents[root1] += parents[root2];
			/*root1 Ϊroot2�ĸ��ڵ�*/
			parents[root2] = root1;
		}
	}

	public int countRoot() {
		int count = 0;
		/*��1��ʼ ͳ��parent��-1�ļ�Ϊ���ڵ�*/
		for (int i = 1; i <= n; ++i) {
			if (parents[i] < 0) {
				++count;
			}
		}
		return count;
	}
}