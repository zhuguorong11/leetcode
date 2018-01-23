import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author zhugr
 *
 */
public class BSTIterator {

	Stack<TreeNode> stack;
	// use inorder
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			if (root.left != null)
				root = root.left;
			else
				break;
		}
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	/** @return the next smallest number */
	public int next() {
		TreeNode curNode = stack.pop();
		// right part
		TreeNode nodeCopy = curNode;
		if (nodeCopy.right != null) {
			nodeCopy = nodeCopy.right;
			while (nodeCopy != null) {
				stack.push(nodeCopy);
				if (nodeCopy.left != null) 
					nodeCopy = nodeCopy.left;
				else
					break;
			}
		}
		return curNode.val;
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