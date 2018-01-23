import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * Example 1: Input:
 * 
 * Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 * 
 * Output: 7
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// it means that find the first node of the last row
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int lastLeft = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				if (i == 0)
					lastLeft = curNode.val;
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			}
		}
		return lastLeft;
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