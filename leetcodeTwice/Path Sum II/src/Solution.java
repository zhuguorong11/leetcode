import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13
 * 4 / \ / \ 7 2 5 1 return [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		dfs(root, res, cur, sum);
		return res;
	}

	public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> cur, int sum) {
		if (node == null)
			return;
		cur.add(node.val);
		if (node.left == null && node.right == null && node.val == sum) {
			res.add(new ArrayList<>(cur));
		}
		dfs(node.left, res, cur, sum - node.val);
		dfs(node.right, res, cur, sum - node.val);
		cur.remove(cur.size() - 1);// backtrace
		return;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}