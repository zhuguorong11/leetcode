import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {4,2,14,51,3};
		// Solution.maximumGap(nums);
		// for(int n : nums){
		// System.out.print(n + " ");
		// }
	}

	public static int maximumGap(int[] nums) {
		/* maybe can use count sort */
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int min = nums[0];
		int max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		/* // store the min value in that bucket */
		int[] bucketsMIN = new int[nums.length - 1];
		/* // store the max value in that bucket */
		int[] bucketsMAX = new int[nums.length - 1];
		/* the minimum possibale gap, ceiling of the integer division */
		int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);

		/* put numbers into buckets */
		for (int num : nums) {
			if (num == min || num == max) {
				continue;
			}

			/* index of the right position in the buckets */
			int buckIndex = (num - min) / gap;
			bucketsMIN[buckIndex] = Math.min(num, bucketsMIN[buckIndex]);
			bucketsMAX[buckIndex] = Math.max(num, bucketsMAX[buckIndex]);
		}
		/* scan the buckets for the max gap */
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length - 1; ++i) {
			//empty
			if (bucketsMAX[i] == Integer.MIN_VALUE && bucketsMIN[i] == Integer.MAX_VALUE) {
				continue;
			}
			//后一个bucket中的min 和 前一个bucket中的max进行比较 
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			previous = bucketsMAX[i];
		}
		/* updata the final max value gap */
		maxGap = Math.max(max - previous, maxGap);
		return maxGap;
	}
}
