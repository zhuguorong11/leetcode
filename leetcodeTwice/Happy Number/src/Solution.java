import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int r;
		while (set.add(n)) {// if can add , that means this sum never
							// appears,else it have appeared
			int sum = 0;
			while (n > 0) {
				r = n % 10;
				sum += r * r;
				n /= 10;
			}
			if (sum == 1)
				return true;
			else
				n = sum;
		}
		return false;
	}
}
