/*
 * iven two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return dfs(p, q);
	}

	public boolean dfs(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null)
			return false;
		else if (p.val != q.val)
			return false;
		else
			return dfs(p.left, q.left) && dfs(p.right, q.right);
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