import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		// 该map通过值来映射索引
		for (int i = 0; i < inorder.length; ++i) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}

	public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
		if (ps > pe || is > ie)
			return null;
		int inIndex = map.get(preorder[ps]);
		TreeNode node = new TreeNode(preorder[ps]);
		TreeNode leftNode = helper(preorder, ps + 1, ps + (inIndex - is), inorder, is, inIndex - 1, map);
		TreeNode rightNode = helper(preorder, ps + (inIndex - is + 1), pe, inorder, inIndex + 1, ie, map);

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