/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Example: Given a binary tree 1 / \ 2 3 / \ 4 5 Return 3, which is the length
 * of the path [4,2,1,3] or [5,2,1,3].
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {

	}

	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		// find the max depth of both subtree
		getMaxDepth(root);
		return diameter;
	}

	public int getMaxDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = getMaxDepth(node.left);
		int right = getMaxDepth(node.right);
		diameter = Math.max(diameter, left + right);//because the max diameter maybe occur in one side,so we should use max()function
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