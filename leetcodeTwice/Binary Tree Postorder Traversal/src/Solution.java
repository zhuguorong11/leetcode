import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 * 1 
 * \ 
 * 2 
 * /
 *3 return [3,2,1].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		postOrderTravel(root, res);
		return res;
	}

	public void postOrderTravel(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		postOrderTravel(node.left, res);
		postOrderTravel(node.right, res);
		res.add(node.val);
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