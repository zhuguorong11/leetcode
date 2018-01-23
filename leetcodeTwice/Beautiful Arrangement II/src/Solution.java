/**
 * Given two integers n and k, you need to construct a list which contains n
 * different positive integers ranging from 1 to n and obeys the following
 * requirement: Suppose this list is [a1, a2, a3, ... , an], then the list [|a1
 * - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
 * integers.
 * 
 * If there are multiple answers, print any of them.
 * 
 * Example 1: Input: n = 3, k = 1 Output: [1, 2, 3] Explanation: The [1, 2, 3]
 * has three different positive integers ranging from 1 to 3, and the [1, 1] has
 * exactly 1 distinct integer: 1. Example 2: Input: n = 3, k = 2 Output: [1, 3,
 * 2] Explanation: The [1, 3, 2] has three different positive integers ranging
 * from 1 to 3, and the [2, 1] has exactly 2 distinct int
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] constructArray(int n, int k) {
		/*can notice that there has max k == n - 1
		like if n = 9, the max of k is 8
		denote l = 1, r = n
		l++ r-- l++ r-- ....
		1 2 3 4 5 
		 9 8 7 6
		so if k is smaller than n - 1,than we can move the left and right
		like k = 5
		l++ r-- l++ r-- l++ l++ l++ l++ l++
		so 1 2 3 4 5 6 7
			9 8
		*/
		int[] res = new int[n];
		for(int i = 0,l = 1,r = n; l <= r && i < n; ++i){
			if(k > 1){
				if(k % 2 == 1)//odd
				{
					res[i] = l++;
				}else{//even
					res[i] = r--;
				}
				--k;
			}else
				res[i] = l++;
		}
		return res;
	}
}
