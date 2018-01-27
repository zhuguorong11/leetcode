import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.decodeString("2[abc]3[cd]ef"));
	}

	public static String decodeString(String s) {
		// we use two stack,one stack store the repeat times,the other stack the
		// string we should repeat
		Stack<Integer> repeatTime = new Stack<>();
		Stack<StringBuilder> repeatString = new Stack<>();
		StringBuilder sBuilder = new StringBuilder();
		int perRepeat = 0;
		for (int i = 0; i < s.length(); ++i) {
			char letter = s.charAt(i);
			if (Character.isDigit(letter))
				perRepeat = perRepeat * 10 + letter - '0';// record repeatTime
			else if (letter == '[') {
				// then we shoud push the perRepeat into repeatTime stack
				repeatTime.push(perRepeat);
				perRepeat = 0;// recount the next repeat
				repeatString.push(sBuilder);
				sBuilder = new StringBuilder();//restart to record netext string in [];
			} else if (letter == ']') {
				int repeatNow = repeatTime.pop();
				StringBuilder needRepeatString = sBuilder;// the String we should repeat
				sBuilder = repeatString.pop();// last store String
				for (int j = 0; j < repeatNow; ++j) {
					sBuilder.append(needRepeatString.toString());//append repeat string after last sbuilder
				}
			} else
				sBuilder.append(letter);
		}
		return sBuilder.toString();
	}
}