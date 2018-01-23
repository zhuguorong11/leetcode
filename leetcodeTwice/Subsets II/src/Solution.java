import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		res.add(new ArrayList<>());
		for (int num : nums) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();// 临时的一个列表
			for (List<Integer> sub : res) {
				List<Integer> subTemp = new ArrayList<>(sub);
				subTemp.add(num);
				if (!res.contains(subTemp)) {//去除重复的list
					temp.add(subTemp);
				}
			}
			res.addAll(temp);
		}
		return res;
	}
}
