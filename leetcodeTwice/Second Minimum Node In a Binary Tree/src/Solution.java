import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findSecondMinimumValue(TreeNode root) {
		// use dfs
		if (root == null) {
			return -1;
		}
		int count = 0;
		Set<Integer> set = new TreeSet<>();// ÅÅÐòºÃµÄ
		dfs(root, set);
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			++count;
			int val = iterator.next();
			if (2 == count)
				return val;
		}
		return -1;
	}

	public void dfs(TreeNode node, Set<Integer> set) {
		if (node == null)
			return;
		set.add(node.val);
		dfs(node.left, set);
		dfs(node.right, set);
		return;
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