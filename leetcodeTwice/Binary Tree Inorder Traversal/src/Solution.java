import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		inOrder(root, res);
		return res;
	}
	public void inOrder(TreeNode node, List<Integer> res) {
		if (node == null)
			return;
		inOrder(node.left, res);
		res.add(node.val);
		inOrder(node.right, res);
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