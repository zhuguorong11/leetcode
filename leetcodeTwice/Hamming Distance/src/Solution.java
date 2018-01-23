/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ¡Ü x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ¡ü   ¡ü

The above arrows point to positions where the corresponding bits are different.
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int hammingDistance(int x, int y) {
        int res = 0;
        while(x != 0 || y != 0)
        {
        	int rx = x & 1;
			int ry = y & 1;
			x = x >>> 1;
			y = y >>> 1;
			if(rx != ry)
			{
				++res;
			}
        }
        return res;
    }
}
