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
		//���������ƽ����������Ϊ�б�ƽ��������������һ��ֻ����һ�Σ�����1
		//�¹��Ƿ�ƽ��������������ˣ��໥����������0
		//����ͳ��<=n��ƽ��������
		for(int i = 1; i*i <= n; ++i){
			++res;
		}
		return res;
	}
}
