import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * iven a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return res;
		Map<List<Integer>, Integer> map = new HashMap<>();
		List<Integer> in = new ArrayList<>();
		in.add(nums[0]);
		res.add(in);// initial
		for (int i = 1; i < nums.length; ++i) {
			List<List<Integer>> res_copy = new ArrayList<List<Integer>>();
			for (int j = 0; j <= i; ++j) {//每一个插入的位置
				for (List<Integer> in_list : res) {
					// cut in j position
					List<Integer> in_list_copy = new ArrayList<>(in_list);
					in_list_copy.add(j, nums[i]);
					if (!map.containsKey(in_list_copy)) {
						res_copy.add(in_list_copy);
						map.put(in_list_copy, 1);
					} else
						in_list_copy.remove(j);
				}
			}
			res = res_copy;
		}
		return res;
	}
}
