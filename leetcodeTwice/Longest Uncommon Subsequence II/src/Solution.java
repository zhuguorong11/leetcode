import java.util.Arrays;
import java.util.Comparator;

/**
 * The input will be a list of strings, and the output needs to be the length of
 * the longest uncommon subsequence. If the longest uncommon subsequence doesn't
 * exist, return -1.
 * 
 * Example 1: Input: "aba", "cdc", "eae" Output: 3
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// one of these strings and this subsequence should not be any subsequence
	// of the other strings.
	public int findLUSlength(String[] strs) {
		// �����ַ������Ƚ�������
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		int len = strs.length;
		for (int i = 0; i < len; ++i) {
			int strsCount = len - 1;//��ȥ�Լ�����
			for (int j = 0; j < len; ++j) {
				if (i != j && !isSubSequence(strs[i], strs[j])) {
					--strsCount;
				}
			}
			if (strsCount == 0) {
				return strs[i].length();
			}
		}
		return -1;
	}

	public boolean isSubSequence(String s1, String s2) {
		int index = 0;
		for (char ch : s2.toCharArray()) {
			if (index < s1.length() && ch == s1.charAt(index)) {
				++index;
			}
		}
		return index == s1.length();// true��ʾs1Ϊs2��������
	}
}
