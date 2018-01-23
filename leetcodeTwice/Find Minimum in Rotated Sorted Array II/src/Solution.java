/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] < nums[r])//go left
				r = mid;// because mid maybe is the mininum number,so should not
						// be r = mid + 1
			else if (nums[mid] > nums[r])//go right
				l = mid + 1;
			else
				--r;
		}
		return nums[r];
	}
}
