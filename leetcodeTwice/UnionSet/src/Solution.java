import java.util.Arrays;

/**
 * 并查集实现解决朋友圈问题 假如已知有n个人和m对好友关系（存于数字r）。如果两个人是直接或间接的好友（好友的好友的好友…），则认为他们属于同一个朋友圈，
 * 请写程序求出这n个人里一共有多少个朋友圈。 假如：n = 5，m = 3，r = {{1 , 2} , {2 , 3} , {4 ,
 * 5}}，表示有5个人，1和2是好友，2和3是好友，4和5是好友，则1、2、3属于一个朋友圈，4、5属于另一个朋友圈，结果为2个朋友圈。
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
	 *            ： n个人
	 */
	int n;
	int[] parents;

	public UnionSet(int n) {
		this.n = n;
		parents = new int[n + 1];
		/*
		 * 先初始化每个人的祖先是-1
		 */
		Arrays.fill(parents, -1);
	}

	/* 查找某一个朋友圈根节点 */
	public int find(int index) {
		int root = index;
		/*parents[root] > 0表示还有父节点*/
		while (parents[root] > 0) {
			root = parents[root];
		}
		return root;
	}

	/* 两个朋友的关系 */
	public void union(int r1, int r2) {
		int root1 = find(r1);
		int root2 = find(r2);
		/*r1和r2没有共同祖先*/
		if (root1 != root2) {
			parents[root1] += parents[root2];
			/*root1 为root2的父节点*/
			parents[root2] = root1;
		}
	}

	public int countRoot() {
		int count = 0;
		/*从1开始 统计parent是-1的即为根节点*/
		for (int i = 1; i <= n; ++i) {
			if (parents[i] < 0) {
				++count;
			}
		}
		return count;
	}
}