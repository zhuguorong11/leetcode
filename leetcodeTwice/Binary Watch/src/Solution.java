import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> readBinaryWatch(int num) {
		// use Integer.bitCount(int)
		// return the bit number of this int
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 12; ++i) {
			for (int j = 0; j < 60; ++j) {
				if (Integer.bitCount(i) + Integer.bitCount(j) == num)
					res.add(String.format("%d:%02d", i, j));
			}
		}
		return res;
	}
}
