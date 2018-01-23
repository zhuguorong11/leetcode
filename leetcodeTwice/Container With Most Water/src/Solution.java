
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		int len = height.length;
		// ����ָ��
		int left = 0;
		int right = len - 1;
		int mostWater = 0;
		while (left < right) {
			int curWater = Math.min(height[left], height[right]) * (right - left);
			mostWater = Math.max(mostWater, curWater);
			if (height[left] < height[right])
				++left;
			else
				--right;
		}
		return mostWater;
	}
}
