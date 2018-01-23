import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return list;
		}
		int len = s.length();
		for (int i = 1; i < len - 2; ++i) {
			for (int j = i; j < len - 1; ++j) {
				for (int k = j; k < len; ++k) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						list.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return list;
	}

	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0') || Integer.parseInt(s) > 255) {
			return false;
		}else
			return true;
	}
}
