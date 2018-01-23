import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumNumbers(TreeNode root) {
//		if (root == null)
//			return 0;
//		List<Integer> numList = new ArrayList<>();
//		dfs(root, numList, "");
//		int sum = 0;
//		for (int num : numList)
//			sum += num;
//		return sum;
		
		return dfs2(root, 0);
	}

	public void dfs(TreeNode node, List<Integer> list, String s) {
		if (node == null)
			return;
		// if (node.left == null && node.right == null) {//leaf
		// list.add(Integer.parseInt(s));
		// return;
		// }
		dfs(node.left, list, s + node.val);
		if (node.left == null && node.right == null) {// leaf
			list.add(Integer.parseInt(s + node.val));
			return;
		}
		dfs(node.right, list, s + node.val);
		return;
	}

	// another
	public int dfs2(TreeNode node, int num) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return num * 10 + node.val;
		else
			return dfs2(node.left, num * 10 + node.val) + dfs2(node.right, num * 10 + node.val);
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