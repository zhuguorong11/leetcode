import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer. 罗马数字 I,V,X,L,C,D,M
 * 依次为阿拉伯数字的1,5,10,50,100,500,1000 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * 
 * 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * 
 * 3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 * 
 * 4、正常使用时，连写的数字重复不得超过三次。
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int romanToInt(String s) {
		Map<Character, Integer> mp = new HashMap<>();
		mp.put('I', 1);
		mp.put('V', 5);
		mp.put('X', 10);
		mp.put('L', 50);
		mp.put('C', 100);
		mp.put('D', 500);
		mp.put('M', 1000);
		char[] chs = s.toCharArray();
		int len = chs.length;
		int res = 0;
		for (int i = 0; i < len - 1; ++i) {
			int a = mp.get(chs[i]);
			int b = mp.get(chs[i + 1]);
			if (a < b)
				res -= a;
			else
				res += a;
		}
		return res + mp.get(chs[len - 1]);
	}
}
