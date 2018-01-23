import java.util.Arrays;

/**
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。写一个函数实现此功能。
 * 
 * 注意事项： 不需要保持正整数或者负整数原来的顺序。
 * 
 * 挑战： 原地完成，没有额外的空间
 * 
 * 格式：
 * 
 * 输入第一行输入一个原始数组，最后输出重新排列后的数组。
 * 
 * 样例输入
 * 
 * [ -1，-2，-3，4，5，6 ] 样例输出
 * 
 * [ -1，5，-2，4，-3，6 ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-2,-3,4,5,6,3};
		Solution solution = new Solution();
		solution.reRange(nums);
		for(int num : nums){
			System.out.print(num + " ");
		}
	}

	public void reRange(int[] nums) {
		/* sort firts to make negative numbers leading */
		Arrays.sort(nums);
		int len = nums.length;
		int negative = 1;
		int positive = len - 2;
		if ((len & 1) == 1) {
			if (nums[len / 2] < 0) {
				swap(nums, len / 2, len - 1);
				negative = 1;
				positive = len - 3;
			} else {
				swap(nums, len / 2, 0);
				negative = 2;
				positive = len - 2;
			}
		}
		while (negative < positive) {
			swap(nums, negative, positive);
			negative += 2;
			positive -= 2;
		}
	}

	public void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
