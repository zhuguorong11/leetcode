/**
 * Given a non-empty string containing an out-of-order English representation of
 * digits 0-9, output the digits in ascending order.
 * 
 * Note: Input contains only lowercase English letters. Input is guaranteed to
 * be valid and can be transformed to its original digits. That means invalid
 * inputs such as "abc" or "zerone" are not permitted. Input length is less than
 * 50,000. Example 1: Input: "owoztneoer"
 * 
 * Output: "012" Example 2: Input: "fviefuro"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String originalDigits(String s) {
		// ����0-9��ĸ���ص㣬����zֻ��0����
		int[] nums = new int[10];
		for (Character c : s.toCharArray()) {
			if ('z' == c)
				++nums[0];
			if (c == 'w')
				nums[2]++;// 'w'ֻ��2����
			if (c == 'x')
				nums[6]++;// 'x'ֻ��6����
			if (c == 's')
				nums[7]++;// 6,7���У����ֻҪnums[7]-nums[6]����
			if (c == 'g')
				nums[8]++;
			if (c == 'u')
				nums[4]++;
			if (c == 'f')
				nums[5]++;// 5-4
			if (c == 'h')
				nums[3]++;// 3-8
			if (c == 'i')
				nums[9]++;// 9-5-6-8
			if (c == 'o')
				nums[1]++;// 1-2-0-4
		}
		// ���Եõ�����Ψһ����ĸ
		nums[7] -= nums[6];
		nums[5] -= nums[4];
		nums[3] -= nums[8];
		nums[9] = nums[9] - nums[5] - nums[6] - nums[8];
		nums[1] = nums[1] - nums[2] - nums[0] - nums[4];
		StringBuilder sBuilder = new StringBuilder();
		// ��ʼͳ��
		for (int i = 0; i < 10; ++i) {
			for (int j = 1; j <= nums[i]; ++j) {
				sBuilder.append(i);
			}
		}
		return sBuilder.toString();
	}
}
