/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees. Example 1: 
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
  Binary tree [1,2,3], return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		return subIsValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean subIsValid(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		if (node.val >= max || node.val <= min)
			return false;
		return subIsValid(node.left, min, node.val) && subIsValid(node.right, node.val, max);
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