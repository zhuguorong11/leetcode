import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 *  1 
 *  \ 
 *  2 
 *  / 
 *  3 return [1,2,3].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		preOrder(root, res);
		return res;
	}

	public void preOrder(TreeNode node, List<Integer> res) {
		if(node == null)
			return ;
		res.add(node.val);
		preOrder(node.left, res);
		preOrder(node.right, res);
		return ;
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