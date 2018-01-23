/**
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 * 
 * Example: Given n = 2, return 91. (The answer should be the total numbers in
 * the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.countNumbersWithUniqueDigits(11));
	}

	/**
	 * f(1) = 10. (0, 1, 2, 3, ...., 9)

	   f(2) = 9 * 9. 

       f(3) = f(2) * 8 = 9 * 9 * 8
       
       f(4) = f(3) * 7 = 9 * 9 * 8 * 7
       ......
       f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
       f(11) = f(10) ....
	 * @param n
	 * @return
	 */
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int uniqueDigits = 9;// 1,2,3,4,5,6,7,8,9
		// 因为最多只能
		int res = 10;//n==1时的初始化数量
		for(int i = 2; i <= n && i <= 10; ++i) {
			uniqueDigits = uniqueDigits * (9 - i + 2);
			res += uniqueDigits;
		}
		return res;
	}
}
