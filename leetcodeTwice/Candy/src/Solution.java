import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int candy(int[] ratings) {
		int len = ratings.length;
		int[] childCandy = new int[len];
		/* left -> right */
		Arrays.fill(childCandy, 1);
		for (int i = 1; i < len; ++i) {
			if (ratings[i] > ratings[i - 1]) {
				childCandy[i] = childCandy[i - 1] + 1;
			}
		}
		/* right -> left */
		for (int i = len - 2; i >= 0; --i) {
			if (ratings[i] > ratings[i + 1] && childCandy[i] <= childCandy[i + 1]) {
				childCandy[i] = childCandy[i + 1] + 1;
			}
		}
		int sum = 0;
		for (int child : childCandy) {
			sum += child;
		}
		return sum;
	}
}
