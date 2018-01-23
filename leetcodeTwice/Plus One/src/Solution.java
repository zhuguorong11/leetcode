/*
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 * */
public class Solution {
	public static void main(String[] args) {

	}

	public int[] plusOne(int[] digits) {
		// 从末尾开始加
		int len = digits.length;
		for (int i = len - 1; i >= 0; --i) {
			if (digits[i] != 9) {
				++digits[i];
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		// 若要进位则只会出现如100000 1000 1000000之类的
		int[] jinWei = new int[len + 1];
		jinWei[0] = 1;
		return jinWei;
	}
}
