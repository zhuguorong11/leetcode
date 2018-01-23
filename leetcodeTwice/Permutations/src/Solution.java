import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return res;
		List<Integer> in = new ArrayList<>();
		in.add(nums[0]);
		res.add(in);// initial
		for (int i = 1; i < nums.length; ++i) {
			List<List<Integer>> res_copy = new ArrayList<List<Integer>>();
			for (int j = 0; j <= i; ++j) {
				for (List<Integer> in_list : res) {
					// cut in j position
					List<Integer> in_list_copy = new ArrayList<>(in_list);
					in_list_copy.add(j, nums[i]);
					res_copy.add(in_list_copy);
				}
			}
			res = res_copy;
		}
		return res;
	}
}
