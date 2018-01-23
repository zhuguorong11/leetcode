/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return true;
			//left is sorted or right is unsorted
			if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			//right is sorted or left is unsorted
			} else if(nums[mid] < nums[end] || nums[mid] < nums[start]){
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			//we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
	        //any of the two sides won't change the result but can help remove duplicate from
	        //consideration, here we just use end--
			}else
				--end;
		}
		return false;
	}
}
