import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0, right = 0, max = Integer.MIN_VALUE;//�����ƶ�
		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(left++));// Ϊ�˽�s.charAt(j)���뵽set�У��ͱ����set��֮ǰ�������ͬ���ַ�ȥ����ͬʱ�����൱�ڰ���ͬ�ַ�֮ǰ�������ַ���ȥ��
			}
		}
		return max;
	}
}
