/**
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows: ก่ ก่ ก่ ก่ ก่
 * 
 * Because the 3rd row is incomplete, we return 2. Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows: ก่ ก่ ก่ ก่ ก่ ก่ ก่ ก่
 * 
 * Because the 4th row is incomplete, we return 3.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		System.out.println(Solution.arrangeCoins(8));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	public static int arrangeCoins(int n) {
//		int countStair = 0;
//		int curTotalCoin = 0;
//		while (curTotalCoin <= n) {
//			++countStair;
//			curTotalCoin += countStair;		
//		}
//		countStair -= 1;
//		return countStair;
		
		int level = 1;
		int left = n - 1;
		while(left >= 0){
			++level;
			left -= level;
//			++level;
//			if(left > level)
//				left -= level;
//			else if(left == level)
//				return level;
//			else
//				return --level;
//				left -= level;
		}
		return --level;
	}
}
