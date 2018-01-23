
/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 �� 2
[1,3,5,6], 2 �� 1
[1,3,5,6], 7 �� 4
[1,3,5,6], 0 �� 0
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		System.out.println(Solution.searchInsert(nums, 7));
	}

	public static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				end = mid - 1;
			else {
				start = mid + 1;
			}
		}
		return start;
	}
}
