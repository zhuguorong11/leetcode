/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * Example 1: Given tree s:
 * 
 * 3 / \ 4 5 / \ 1 2 Given tree t: 4 / \ 1 2 Return true, because t has the same
 * structure and node values with a subtree of s. Example 2: Given tree s:
 * 
 * 3 / \ 4 5 / \ 1 2 / 0 Given tree t: 4 / \ 1 2 Return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null)
			return false;
		if (s.val == t.val) {
			if (isSub(s, t))
				return true;
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public boolean isSub(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		if (node1.val == node2.val)
			return isSub(node1.left, node2.left) && isSub(node1.right, node2.right);
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