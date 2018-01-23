/**
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. The left subtree is the maximum
 * tree constructed from left part subarray divided by the maximum number. The
 * right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. Construct the maximum tree by the given array
 * and output the root node of this tree.
 * 
 * Example 1:Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return dfs(nums, 0, nums.length - 1);
	}

	public TreeNode dfs(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int maxIndex = start;
		for (int i = start + 1; i <= end; ++i) {
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
		}
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = dfs(nums, start, maxIndex - 1);
		root.right = dfs(nums, maxIndex + 1, end);
		return root;
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