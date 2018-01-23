/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *  3
   / \
  9  20
    /  \
   15   7

 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author zhugr
 *	
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumOfLeftLeaves(TreeNode root) {
		int leftSum = 0;
		if (root == null)
			return 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {//leave
				leftSum += root.left.val;
			} else
				leftSum += sumOfLeftLeaves(root.left);
		}
		if (root.right != null)
			leftSum += sumOfLeftLeaves(root.right);
		return leftSum;
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