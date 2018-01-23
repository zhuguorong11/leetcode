import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * Example 1: Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// method1 use inorder
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> nums = new ArrayList<>();
		inorder(root, nums);
		int i = 0, j = nums.size() - 1;
		while (i < j) {
			if (nums.get(i) + nums.get(j) == k)
				return true;
			else if (nums.get(i) + nums.get(j) < k)
				++i;
			else
				--j;
		}
		return false;
	}

	public void inorder(TreeNode node, List<Integer> nums) {
		if (node == null)
			return;
		inorder(node.left, nums);
		nums.add(node.val);
		inorder(node.right, nums);
		return;
	}

	// use iteration
	public boolean findTarget2 (TreeNode root, int k) {
		return dfs(root, root, k);
	}
	public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)
        	return false;
        return helper(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
	public boolean helper(TreeNode node1, TreeNode node2, int k) {
		if (node1 == null)
			return false;
		return (node1.val == k) && (node1 != node2) || (node1.val < k) && helper(node1.right, node2, k)
				|| (node1.val > k) && helper(node1.left, node2, k);
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