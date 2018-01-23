/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	public int getDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return Math.max(left, right) + 1;
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