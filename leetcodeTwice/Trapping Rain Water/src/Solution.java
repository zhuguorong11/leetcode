/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(Solution.trap(nums));
	}

	public static int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int l = 0, r = height.length - 1;
		while (l < r && height[l] < height[l + 1])
			++l;// find the start bar
		while (l < r && height[r] < height[r - 1])
			--r;// find the end bar
		int water = 0;
		while (l < r) {
			int left = height[l];
			int right = height[r];
			if (left < right) {//decided by min bar
				while (l < r && height[l] <= left) {
					water += left - height[l];
					++l;
				}
			} else {
				while (l < r && height[r] <= right) {
					water += right - height[r];
					--r;
				}
			}
		}
		return water;
	}
}
