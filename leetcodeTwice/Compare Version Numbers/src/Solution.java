/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * 
 * 还要注意可能出现的1.2.23 多个.的
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");

		// 要找到.最多的字符串数组
		int len = Math.max(s1.length, s2.length);
		for (int i = 0; i < len; i++) {
			// 判断是否有值，没有的话赋值为0
			int num1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
			int num2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
			if (num1 < num2) {
				return -1;
			} else if (num1 > num2) {
				return 1;
			}
		}
		return 0;
	}
}
