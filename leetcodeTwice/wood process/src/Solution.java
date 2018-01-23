/**
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为
 * k。当然，我们希望得到的小段越长越好，编写一个函数计算能够得到的小段木头的最大长度。
 * 
 * 注意事项： 木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。无法切出要求至少 k 段的,则返回 0 即可。
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
