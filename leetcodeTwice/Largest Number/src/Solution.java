import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		int len = nums.length;
		String[] strs = new String[len];
		for (int i = 0; i < len; ++i) {
			strs[i] = String.valueOf(nums[i]);
		}

		/* we should sort desc by s1 + s2 */
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				/* desc */
				return s2.compareTo(s1);
			}
		});

		StringBuilder sBuilder = new StringBuilder();
		for (String string : strs) {
			sBuilder.append(string);
		}
		
		/*should judge whether string starts with 0*/
		return sBuilder.charAt(0) == '0' ? "0" :sBuilder.toString();
	}
}
