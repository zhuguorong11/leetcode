/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *   1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return subIsSymmetric(root.left, root.right);
	}
	public boolean subIsSymmetric(TreeNode left,TreeNode right){
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		if (left.val == right.val) {
			return subIsSymmetric(left.left,right.right) && subIsSymmetric(left.right, right.left);
		}
		else
			return false;
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