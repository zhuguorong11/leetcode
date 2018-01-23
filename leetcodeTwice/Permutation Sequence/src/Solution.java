import java.util.ArrayList;
import java.util.List;

/**
 * he set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; ++i)
			list.add(i);
		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; ++i)
			factorial[i] = i * factorial[i - 1];// so factorial = {1, 1, 2, 6,24, ... n - 1!}

		--k;// list index begins from zero
		StringBuilder sbBuilder = new StringBuilder();
		for (int i = n; i > 0; --i) {
			int curIndex = k / factorial[i - 1];//k/(n-1)! indicates the index of current number 表示第几个数的索引
			k = k % factorial[i - 1];//k%(n-1)! denotes remaining index for the remaining n-1 numbers 在第几个数开头的情况下的索引位置
			sbBuilder.append(list.get(curIndex));
			list.remove(curIndex);
		}
		return sbBuilder.toString();
	}

}
