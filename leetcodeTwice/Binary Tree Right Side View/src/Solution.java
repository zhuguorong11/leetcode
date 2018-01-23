import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree, 
 *  
 *   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


You should return [1, 3, 4].
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//use bfs
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode curNode = queue.peek();
				int curVal = curNode.val;
				if (i == size - 1)
					res.add(curVal);
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			}
		}
		return res;
	}
	
	//use dfs
	public void dfs(TreeNode node, List<Integer> res, int level){
		if(node == null)
			return;
		if(level == res.size())
			res.add(node.val);
		dfs(node.right, res, level+1);
		dfs(node.left, res, level + 1);
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