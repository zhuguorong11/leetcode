import java.util.List;
import java.util.ArrayList;

/*
 * Given an integer array of size n, find all elements that appear more than n/3times. 
 * The algorithm should run in linear time and in O(1) space.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return list;
		int count1 = 0, count2 = 0, num1 = nums[0], num2 = nums[0];
		for (int i = 0; i < nums.length; ++i) {
			if (num1 == nums[i]) {
				++count1;
			} else if (num2 == nums[i]) {
				++count2;
			} else if (count1 == 0) {
				num1 = nums[i];
				++count1;
			} else if (count2 == 0) {
				num2 = nums[i];
				++count2;
			} else {
				--count1;
				--count2;
			}
		}
		// 这时候确定了次数出现最大的2个数
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == num1)
				++count1;
			else if (nums[i] == num2)
				++count2;
		}
		if (count1 > nums.length / 3)
			list.add(num1);
		if (count2 > nums.length / 3)
			list.add(num2);
		return list;
	}
}
