/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, 
 * called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart 
 * thief realized that "all houses in this place forms a binary tree". It will automatically contact the police 
 * if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 采用dfsseach node return two number, int[] num,
	// num[0] is the max value while rob this node,
	// num[1] is max value while not rob this value.
	// Current node return value only depend on its children's value
	public int rob(TreeNode root) {
		int[] res = robDFS(root);
		return Math.max(res[0], res[1]);
	}

	public int[] robDFS(TreeNode node) {
		if (node == null) {
			return new int[2];
		}
		int[] left = robDFS(node.left);
		int[] right = robDFS(node.right);
		int[] res = new int[2];
		res[0] = left[1] + right[1] + node.val;// 抢劫该层，则其下一层都不能抢劫
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);// 不抢劫该层，对于其下层在抢与不抢之间取最大值

		return res;
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