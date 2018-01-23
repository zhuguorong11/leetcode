/**
 * Given a binary tree, return the tilt of the whole tree.
 * 
 * The tilt of a tree node is defined as the absolute difference between the sum
 * of all left subtree node values and the sum of all right subtree node values.
 * Null node has tilt 0.
 * 
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 * Example: Input: 1 / \ 2 3 Output: 1 Explanation: Tilt of node 2 : 0 Tilt of
 * node 3 : 0 Tilt of node 1 : |2-3| = 1 Tilt of binary tree : 0 + 0 + 1 = 1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;
	public int findTilt(TreeNode root) {
		postOrder(root);
		return sum;
	}

	public int postOrder(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = postOrder(node.left);
		int right = postOrder(node.right);
		sum  += Math.abs(left - right);
		return node.val + left + right;
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