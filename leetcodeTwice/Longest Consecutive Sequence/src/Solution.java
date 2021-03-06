import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(Solution.longestConsecutive(nums));
	}

	public static int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int num : nums) {
			if (map.containsKey(num)) {
				continue;
			} else {
				/* 该数的左右两数是否存在，若存在则返回，两数当时的连续数量 */
				int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
				int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
				int sum = left + right + 1;
				map.put(num, sum);
				res = Math.max(res, sum);
				/* 对序列进行扩展，连续序列的两端更新 */
				map.put(num - left, sum);
				map.put(num + right, sum);
			}
		}
		return res;
	}
}
