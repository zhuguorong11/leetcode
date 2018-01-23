import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		dfs(root, "", res);
		return res;
	}

	public void dfs(TreeNode node, String s, List<String> list) {
		if (node.right == null && node.left == null) {// р╤вс
			list.add(s + node.val);
			return;
		}
		s = s + node.val + "->";
		if (node.left != null)
			dfs(node.left, s, list);
		if (node.right != null)
			dfs(node.right, s, list);
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