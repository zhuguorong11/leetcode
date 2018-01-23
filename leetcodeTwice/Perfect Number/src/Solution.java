/**
 * We define the Perfect Number is a positive integer that is equal to the sum
 * of all its positive divisors except itself.
 * 
 * Now, given an integer n, write a function that returns true when it is a
 * perfect number and false when it is not. Example: Input: 28 Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkPerfectNumber(int num) {
		if (num <= 1)
			return false;
		int sqrtNum = (int)Math.sqrt(num);
		int newNum = 1;
		for(int i = 2; i <= sqrtNum; ++i){
			if (num % i == 0) {
				int r = num / i;
				newNum = newNum + i + r;
			}
		}
		return newNum == num;
	}

}
