import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1...n.
 * 
 * For example, Given n = 3, your program should return all 5 unique BST's shown
 * below.
 * 
 *  1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if (n <= 0)
			return res;
		else {
			res = helper(1, n);
			return res;
		}
	}
	public List<TreeNode> helper(int start, int end) {
		List<TreeNode> cur = new ArrayList<>();
		if(start > end)//must add this situation
		{
			cur.add(null);
			return cur;
		}
		if (start == end) {
			cur.add(new TreeNode(start));
			return cur;
		}
		List<TreeNode> leftList, rightList;
		for (int i = start; i <= end; ++i) {//traverse all nums as curRoot
			// use i as root.val
			leftList = helper(start, i - 1);
			rightList = helper(i + 1, end);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode curRoot = new TreeNode(i);
					curRoot.left = left;
					curRoot.right = right;
					cur.add(curRoot);
				}
			}
		}
		return cur;
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