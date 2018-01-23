import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example: Input:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * Output: [1, 3, 9]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//bfs
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; ++i) {
				TreeNode curNode = queue.poll();
				max = Math.max(max, curNode.val);
				if (curNode.left != null)
					queue.add(curNode.left);
				if (curNode.right != null)
					queue.add(curNode.right);
			}
			res.add(max);
		}
		return res;
	}
	public List<Integer> largestValues2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}
	//use dfs
	public void dfs(TreeNode node, List<Integer> res, int level){
		if(node == null)
			return;
		if(res.size() == level)
			res.add(node.val);
		else{
			if(node.val > res.get(level))
				res.set(level, node.val);
		}
		dfs(node.left, res, level+1);
		dfs(node.right, res, level + 1);
		return ;
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