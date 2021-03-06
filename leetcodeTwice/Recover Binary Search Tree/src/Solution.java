/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode first = null;
	TreeNode second = null;
	TreeNode previous = null;

	public void recoverTree(TreeNode root) {
		inOrderTravel(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public void inOrderTravel(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTravel(node.left);
		/* do something */
		/*
		 * in in-order travel, previous node's val is always smaller than
		 * current node
		 */
		if (previous != null && previous.val >= node.val) {
			/* find first incorrect node */
			if (first == null) {
				first = previous;
			}
			second = node;
		}
		/*update previous node*/
		previous = node;
		inOrderTravel(node.right);
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