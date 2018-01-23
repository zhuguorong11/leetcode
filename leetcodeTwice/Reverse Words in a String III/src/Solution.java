/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output:
 * "s'teL ekat edoCteeL tsetnoc" Note: In the string, each word is separated by
 * single space and there will not be any extra space in the string.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWords(String s) {
		String[] strings = s.trim().split("\\s+");
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < strings.length - 1; ++i) {
			sBuilder.append(swap(strings[i], strings[i].length()) + " ");
		}
		String endStr = strings[strings.length - 1];
		return sBuilder.append(swap(endStr, endStr.length())).toString();
	}

	public String swap(String s, int len) {
		int start = 0;
		int end = len - 1;
		char[] ch = s.toCharArray();
		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			++start;
			--end;
		}
		return new String(ch);
	}

	
	//new approach
	public String reverseWords2(String s) {
		char[] chrs = s.toCharArray();
		int k = 0;// ¿Õ¸ñÎ»ÖÃ
		for (int i = 0; i < chrs.length; i++) {
			if (chrs[i] == ' ') {
				swap2(chrs, k, i - 1);
				k = i + 1;
			}
		}
		// add last space words
		swap2(chrs, k, chrs.length - 1);
		return new String(chrs);
	}

	public void swap2(char[] chrs, int start, int end) {
		while (start < end) {
			char temp = chrs[start];
			chrs[start] = chrs[end];
			chrs[end] = temp;
			++start;
			--end;
		}
	}
}
