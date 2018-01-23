import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1: Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2,
 * 4] is a continuous subarray of size 2 and sums up to 6. Example 2: Input:
 * [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4, 7] is
 * an continuous subarray of size 5 and sums up to 42.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkSubarraySum(int[] nums, int k) {
		// 如果相邻两个数为0，则肯定true
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0 && nums[i + 1] == 0)
				return true;
		}
		if (nums == null || nums.length <= 1)
			return false;
		if (k == 0) {
			return false;
		}
		// 若k为负数
		k = k < 0 ? -k : k;
		Set<Integer> set = new HashSet<>();
		set.add(0);// 初始化，例如[1,1] k=2
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i > 0) {// 不能是第一个数 判断是否是k的倍数
				for (int j = (sum / k) * k; j >= k; j = j - k) {
					if (set.contains(sum - j)) {// 有点类似于窗口移动
						return true;
					}
				}
			}
			set.add(sum);
		}
		return false;
	}
}
