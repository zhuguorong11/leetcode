import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0 || inorder.length == 0 || postorder.length != inorder.length)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		// 该map通过值来映射中序索引
		for (int i = 0; i < inorder.length; ++i) {
			map.put(inorder[i], i);
		}
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
		if (is > ie || ps > pe)
			return null;
		int inIndex = map.get(postorder[pe]);
		TreeNode node = new TreeNode(postorder[pe]);
		TreeNode leftNode = helper(inorder, is, inIndex - 1, postorder, ps, ps + (inIndex - is - 1), map);
		TreeNode rightNode = helper(inorder, inIndex + 1, ie, postorder, ps + (inIndex - is), pe - 1, map);

		node.left = leftNode;
		node.right = rightNode;

		return node;
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