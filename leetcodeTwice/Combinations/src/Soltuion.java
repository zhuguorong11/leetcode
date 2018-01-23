import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author zhugr
 *
 */
public class Soltuion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 0 || k <= 0)
			return res;
		helper(res, new ArrayList<>(), 1, n, k);
		return res;
	}
	public void helper(List<List<Integer>> res, List<Integer> cur, int pos, int n, int k) {
		if (cur.size() == k) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = pos; i <= n; ++i) {
			cur.add(i);
			helper(res, cur, i + 1, n, k);
			cur.remove(cur.size() - 1);
		}
		return;
	}
}
