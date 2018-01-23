import java.util.Set;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int curVal = -1;
    int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		// Set<Integer> set = new TreeSet<>();
		// dfs(root, set);
		// Iterator<Integer> iterator = set.iterator();
		// int count = 0;
		// while (iterator.hasNext()) {
		// ++count;
		// int curVal = iterator.next();
		// if (count == k)
		// return curVal;
		// }
		// return -1;
		inorder(root, k);
		return curVal;
	}

	public void dfs(TreeNode node, Set<Integer> set) {
		if (node == null)
			return;
		set.add(node.val);
		dfs(node.left, set);
		dfs(node.right, set);
		return;
	}

	// use inorder
	public void inorder(TreeNode node, int k) {
		if (node == null)
			return;
		inorder(node.left, k);
		++count;
		if (count == k) {
			curVal = node.val;
			return;
		}
		inorder(node.right, k);
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