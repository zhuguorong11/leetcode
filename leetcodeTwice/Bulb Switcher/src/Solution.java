/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the ith
 * round, you toggle every i bulb. For the nth round, you only toggle the last
 * bulb. Find how many bulbs are on after n rounds.
 * 
 * 
 * Example:
 * 
 * Given n = 3.
 * 
 * At first, the three bulbs are [off, off, off]. After first round, the three
 * bulbs are [on, on, on]. After second round, the three bulbs are [on, off,
 * on]. After third round, the three bulbs are [on, off, off].
 * 
 * So you should return 1, because there is only one bulb is on.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int bulbSwitch(int n) {
		int res = 0;
		//如果该数是平方数，则因为有被平方数，所以其中一次只进行一次，则是1
		//吐过是非平方数，则两数相乘，相互抵消，还是0
		//所以统计<=n的平方数即可
		for(int i = 1; i*i <= n; ++i){
			++res;
		}
		return res;
	}
}
