import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer. �������� I,V,X,L,C,D,M
 * ����Ϊ���������ֵ�1,5,10,50,100,500,1000 1����ͬ��������д������ʾ����������Щ������ӵõ��������磺�� = 3��
 * 
 * 2��С�������ڴ�����ֵ��ұߣ�����ʾ����������Щ������ӵõ������� �磺�� = 8���� = 12��
 * 
 * 3��С�����֣������ڢ�X ��C���ڴ�����ֵ���ߣ�����ʾ�������ڴ�����С���õ��������磺��= 4����= 9��
 * 
 * 4������ʹ��ʱ����д�������ظ����ó������Ρ�
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
