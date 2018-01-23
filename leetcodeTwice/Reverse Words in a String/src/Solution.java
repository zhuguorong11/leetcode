/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue tase";
		System.out.println(Solution.reverseWords(s));
	}

	public static String reverseWords(String s) {
//		s = s.trim();
//		int len = s.length();
//		if (len == 0) {
//			return "";
//		}
//		StringBuilder sBuilder = new StringBuilder();
//		int start = len;
//		for (int i = len - 1; i >= 0; --i) {
//			if (s.charAt(i) != ' ' && i != 0)
//				continue;
//			else {
//				if(i == 0)
//				{
//					sBuilder.append(s.substring(0, start));
//				}else{
//					sBuilder.append(s.substring(i + 1, start));
//					sBuilder.append(" ");
//				}					
//				start = i;
//			}
//		}
//		return sBuilder.toString();
//		
//		sBuilder.append(" ");
		String[] strings = s.trim().split("\\s+");
		StringBuilder sBuilder = new StringBuilder();
		for (int i = strings.length - 1; i >= 1; --i) {
			sBuilder.append(strings[i] + " ");
		}
		return sBuilder.append(strings[0]).toString();
	}
}
