import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums1)
			if(!map.containsKey(num))
				map.put(num, 1);
		Set<Integer> res = new HashSet<>();
		for (int num : nums2) {
			if(map.containsKey(num))
				res.add(num);
		}
		int[] resArr = new int[res.size()];
		int index = 0;
		Iterator<Integer> iterator = res.iterator();
		while(iterator.hasNext())
		{
			resArr[index++] = iterator.next();
		}
		return resArr;
	}
}
