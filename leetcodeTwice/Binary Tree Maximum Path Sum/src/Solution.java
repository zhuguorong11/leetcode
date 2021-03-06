/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 *     1
      / \
     2   3
 * Return 6.
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxVal = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		postOrderTravel(root);
		return maxVal;
	}

	public int postOrderTravel(TreeNode node) {
		if (node == null) {
			return 0;
		}
		/* 若节点为负数，则可放弃该节点，返回为0 */
		int left = Math.max(0, postOrderTravel(node.left));
		int right = Math.max(0, postOrderTravel(node.right));
		maxVal = Math.max(maxVal, left + right + node.val);
		/*返回支路和最大的sum*/
		return Math.max(left, right) + node.val;
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