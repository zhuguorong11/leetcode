/**
 * 给出一个字符串 A，表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。写一个函数找到删除 k
 * 个数字之后的最小正整数。其中 N <= 240，k <= N。
 * 
 * 格式：
 * 
 * 输入行依次输入一个字符串代表的正整数 A 和一个整数 k，最后输出删除 k 个数字之后的最小正整数。
 * 
 * 样例输入
 * 
 * A = 178542 k = 4
 * 
 * 样例输出
 * 
 * 12
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.deleteNum("178542", 3));
	}

	public static int deleteNum(String num, int k) {
		if (num.length() <= k) {
			return 0;
		}
		int i = 0;
		while (k-- != 0) {
			i = 0;
			while (i < num.length() - 1 && num.charAt(i) < num.charAt(i + 1)) {
				++i;
			}
			num = num.substring(0, i) + num.substring(i + 1, num.length());
		}

		// maybe start with 00... like 111000 k=3
		for (i = 0; num.charAt(i) == '0'; ++i)
			;
		num = num.substring(i);
		return Integer.parseInt(num);
		
	}
}
