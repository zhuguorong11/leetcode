/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original. Example: Input: s = "abcdefg", k =
 * 2 Output: "bacdfeg"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseStr(String s, int k) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		int start = 0;
		while (start < len) {
			int end = Math.min(start + k - 1, len - 1);// 防止到达最后一个字符
			swap(chs, start, end);
			start += 2 * k;
		}
		return new String(chs);
	}

	public void swap(char[] arr, int i, int j) {
		while (i < j) {
			char temp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = temp;
		}
	}
}
