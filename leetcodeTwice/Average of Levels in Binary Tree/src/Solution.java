import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			long sum = 0;
			for(int i = 0;i < size; ++i){
				TreeNode curNode = queue.poll();
				sum += curNode.val;
				if(curNode.left != null)
					queue.add(curNode.left);
				if(curNode.right != null)
					queue.add(curNode.right);
			}
			res.add(sum * 1.0 / size);
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