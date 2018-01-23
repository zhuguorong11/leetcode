import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * 			(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4,5,5,6 };
		Solution solution = new Solution();
		solution.wiggleSort2(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	/**
	 * we find that when i is odd,that should satisfy conditon like nums[i] >
	 * nums[i-1] when i is even,that should satisfy condition like nums[i] <
	 * nums[i-1]
	 */
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		if (nums.length == 1) {
			return;
		}
		// o(nlogn)
		Arrays.sort(nums);
		int len = nums.length;
		int j = len, k = (len + 1) / 2;
		int[] tmp = new int[len];
		for (int i = 0; i < len; ++i) {
			tmp[i] = nums[i];
		}
		for (int i = 0; i < len; ++i) {
			nums[i] = (i & 1) == 0 ? tmp[--k] : tmp[--j];
		}

	}
	public void wiggleSort2(int[] nums){
		int n = nums.length;
		int mid = n / 2;
		int i = 0,k = n - 1, j = 0;
		while(j <= k){
			if(nums[j] > nums[mid]){
				swap(nums, i++, j++);
			}else if(nums[j] < nums[mid]){
				swap(nums, i, k--);
			}else{
				++j;
			}
		}
	}
	 public void swap(int[] nums, int i ,int j){
	 int temp = nums[i];
	 nums[i] = nums[j];
	 nums[j] = temp;
	 }
}
