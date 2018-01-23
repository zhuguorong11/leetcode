import java.util.Arrays;

/**
 * 有 N 个小孩站成一列。每个小孩有一个评级。按照以下要求，给小孩分糖果： 1、每个小孩至少得到一颗糖果。
 * 2、评级越高的小孩可以比他相邻的两个小孩得到更多的糖果。 写一个函数计算需最少准备多少糖果？
 * 
 * 格式：
 * 
 * 输入第一行依次输入代表小孩评级的数组，最后依次需要准备最少的糖果的数量。
 * 
 * 样例输入
 * 
 * [ 1，2 ] [ 1，1，1 ] [ 1，2，2 ]
 * 
 * 样例输出
 * 
 * 3 3 4
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kids = {1,2,2};
		System.out.println(Solution.sendCandy(kids));
	}

	public static int sendCandy(int[] kids) {
		if (kids == null || kids.length == 0) {
			return 0;
		}
		int len = kids.length;
		int[] everyKids = new int[len];
		Arrays.fill(everyKids, 1);
		/**
		 * from left to right
		 */
		for (int i = 0; i < len - 1; ++i) {
			if (kids[i] > kids[i + 1]) {
				everyKids[i] = everyKids[i + 1] + 1;
			}
		}
		/**
		 * from right to left
		 */
		for (int i = len - 1; i >= 1; --i) {
			if (kids[i] > kids[i - 1]) {
				everyKids[i] = Math.max(everyKids[i], everyKids[i - 1] + 1);
			}
		}
		int total = 0;
		for (int num : everyKids) {
			total += num;
		}
		return total;
	}
}
