import java.util.ArrayList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		if (rowIndex < 0)
			return res;
		for (int i = 0; i <= rowIndex; ++i) { //rowIndex+1个数
			res.add(0, 1);
			for (int j = 1; j < res.size() - 1; ++j) {//第一个和最后一个均为1，所以都不用进行操作
				res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		return res;
	}
}
