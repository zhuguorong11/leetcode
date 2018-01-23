/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 *         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left == null) {
				root = root.right;
				continue;
			}
			TreeNode pre = root.left;
			while (pre.right != null)
				pre = pre.right;// find the right of left subtree
			pre.right = root.right;
			root.right = root.left;
			root.left = null;
			root = root.right;
		}
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