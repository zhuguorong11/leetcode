/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass? Space complexity should be O(n). Can you do it like a boss? Do
 * it without using any builtin function like __builtin_popcount in c++ or in
 * any other language.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;

		// 利用2的幂次方进行判断，将0,1,2-3,4-7,8-15....类似的分成一组，如5就相当于是4+1，13想当于8+5
		// 所以初始化一个pow来表示2的幂次方
		int pow = 1;
		// t来标记2^n到2^(n+1)-1之间的个数
		for (int i = 1, t = 0; i <= num; ++i, ++t) {
			if (i == pow) {
				pow *= 2;
				t = 0;
			}
			dp[i] = dp[t] + 1;
		}
		return dp;
	}
}
