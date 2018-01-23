import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (len == 0)
			return res;
		Arrays.sort(nums);
		int i = 0;
		while (i < len - 2) {// ��Ϊ��Ҫ������������Ҫȷ�����������ֵ
			int iNext = i + 1;
			int end = len - 1;
			while (iNext < end) {
				int sum = nums[i] + nums[iNext] + nums[end];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[iNext], nums[end]));
					while (nums[end] == nums[--end] && iNext < end);
					while (nums[iNext] == nums[++iNext] && iNext < end);
				}else if(sum > 0)
				{
					--end;
				}else{
					++iNext;
				}
			}
			// ��Ҫ���ж���һ��nums[i]�Ƿ����nums[i-1],�������ظ���list
			while (nums[i] == nums[++i] && i < len - 2)
				;
		}
		return res;
	}
}
