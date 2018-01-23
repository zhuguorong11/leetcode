import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree 3 / \ 9 20 / \ 15 7 return its zigzag level
 * order traversal as: [ [3], [20,9], [15,7] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;// even and odd
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> cur = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode curNode = queue.poll();
				if ((level & 1) == 0)
					cur.add(curNode.val);
				else
					cur.add(0, curNode.val);
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			}
			res.add(cur);
			++level;
		}
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