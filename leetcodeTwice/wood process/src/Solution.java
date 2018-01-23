/**
 * ��һЩԭľ�����������Щľͷ�и��һЩ������ͬ��С��ľͷ����Ҫ�õ���С�ε���Ŀ����Ϊ
 * k����Ȼ������ϣ���õ���С��Խ��Խ�ã���дһ�����������ܹ��õ���С��ľͷ����󳤶ȡ�
 * 
 * ע����� ľͷ���ȵĵ�λ�����ס�ԭľ�ĳ��ȶ���������������Ҫ���и�õ���С��ľͷ�ĳ���ҲҪ�����������޷��г�Ҫ������ k �ε�,�򷵻� 0 ���ɡ�
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] woods = {232,124,456};
		Solution solution = new Solution();
		System.out.println(solution.woodProcess(woods, 7));
	}

	public int woodProcess(int[] woods, int k) {
		if (woods == null || woods.length == 0) {
			return 0;
		}
		int allSum = 0;
		int maxLen = 0;
		for (int wood : woods) {
			allSum += wood;
			maxLen = Math.max(maxLen, wood);
		}
		if (allSum < k) {
			return 0;
		}
		int l = 1, r = maxLen;
		while (l < r) {
			int mid = (l + r + 1) / 2;
			if (isOk(woods, k, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	public boolean isOk(int[] woods, int k, int length) {
		int sum = 0;
		for (int wood : woods) {
			sum += wood / length;
		}
		return sum >= k;
	}
}
