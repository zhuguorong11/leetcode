import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays. The result can be in any order.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : nums2) {
			if (map.containsKey(num) && map.get(num) > 0) {
				res.add(num);
				map.put(num, map.get(num) - 1);
			}
		}
		int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); ++i)
			resArr[i] = res.get(i);
		return resArr;
	}
}
