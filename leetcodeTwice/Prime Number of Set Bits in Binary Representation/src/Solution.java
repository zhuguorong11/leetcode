/**
 * Given two integers L and R, find the count of numbers in the range [L, R]
 * (inclusive) having a prime number of set bits in their binary representation.
 * 
 * (Recall that the number of set bits an integer has is the number of 1s
 * present when written in binary. For example, 21 written in binary is 10101
 * which has 3 set bits. Also, 1 is not a prime.)
 * 
 *Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int L = 10, R = 15;
		System.out.println(Solution.countPrimeSetBits(L, R));
	}

	public static int countPrimeSetBits(int L, int R) {
		int res = 0;
		for (int i = L; i <= R; ++i) {
			int oneBitNum = countOne(i);
			if (isPrime(oneBitNum)) {
				++res;
			}
		}
		return res;
	}

	public static int countOne(int num) {
		int count = 0;
		while (num != 0) {
			int bit = num & 1;
			if (bit == 1)
				++count;
			num = num >>> 1;
		}
		return count;
	}

	public static boolean isPrime(int num) {
		if(num == 1){
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
