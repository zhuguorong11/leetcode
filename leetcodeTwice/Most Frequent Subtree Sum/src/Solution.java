import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * Examples 1 Input:
 * 
 *   5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> map;
	int maxCount = Integer.MIN_VALUE;
	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[] {};
		 
		postOrder(root);
		List<Integer> list = new LinkedList<>();
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			if (entry.getValue() == maxCount)
//				list.add(entry.getKey());
//		}
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext())
		{
			int key = iterator.next();
			int value = map.get(key);
			if(value == maxCount)
				list.add(key);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			res[i] = list.get(i);
		return res;
	}

	// use postOrder
	public int postOrder(TreeNode node) {
		if (node == null)
			return 0;
		int leftSum = postOrder(node.left);
		int rightSum = postOrder(node.right);
		int sum = leftSum + rightSum + node.val;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		int count = map.get(sum);
		maxCount = Math.max(maxCount, count);
		return sum;
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