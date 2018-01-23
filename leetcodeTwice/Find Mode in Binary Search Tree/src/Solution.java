import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key. The right subtree of a node contains only nodes with keys
 * greater than or equal to the node's key. Both the left and right subtrees
 * must also be binary search trees. For example: Given BST [1,null,2,2], 1 \ 2
 * / 2 return [2].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// use map and inorder
	Map<Integer, Integer> map;
	int max = 0;

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[]{};
		map = new HashMap<>();
		inorder(root);
		List<Integer> list = new ArrayList<>();
		// for(Entry<Integer, Integer> entry : map.entrySet()){
		// if(entry.getValue() == max)
		// list.add(entry.getKey());
		// }
		for (int key : map.keySet()) {
			if (map.get(key) == max)
				list.add(key);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			res[i] = list.get(i);
		return res;
	}

	public void inorder(TreeNode node) {
		if (node.left != null)
			inorder(node.left);
		map.put(node.val, map.getOrDefault(node.val, 0) + 1);
		max = Math.max(max, map.get(node.val));
		if (node.right != null)
			inorder(node.right);
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