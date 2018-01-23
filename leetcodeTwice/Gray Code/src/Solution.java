import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> grayCode(int n) {
		/*
		 *n = 0:0
		 * n = 1:0,1
		 * n = 2:00,01,11,10(0,1,3,2)
		 * n = 3:000,001,011,010,110,111,101,100(0,1,3,2,6,7,5,4) 
		 * we can find that when n = n, the pre half of list is when n = n - 1
		 * and post half of list is the reverse of pre half plused 2^(n-1)
		 */
		List<Integer> res = new ArrayList<>();
		if(n < 0)
			return res;
		res.add(0);
		int base = 1;
		for(int i = 1; i <= n; ++i){
			for(int j = res.size() - 1; j >= 0; --j){
				res.add(res.get(j) + base);
			}
			base <<= 1;
		}
		return res;
	}
}
