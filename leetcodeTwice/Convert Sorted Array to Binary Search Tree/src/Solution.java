//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		TreeNode root = helper(nums, 0, nums.length - 1);
		return root;
	}

	// get middle num as root
	public TreeNode helper(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int midIndex = start + (end - start) / 2;
		TreeNode node = new TreeNode(nums[midIndex]);
		node.left = helper(nums, start, midIndex - 1);
		node.right = helper(nums, midIndex + 1, end);
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