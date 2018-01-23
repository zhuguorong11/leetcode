import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 
 1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the
 * form of a list.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		helper(root, new HashMap<>(), res);
		return res;
	}
	//use map,string as key , nums of this string as value
	public String helper(TreeNode node , Map<String, Integer> map,List<TreeNode> res){
		if(node == null)
			return "";
		String ss = node.val + "," + helper(node.left, map, res) + "," + helper(node.right, map, res);
		if(map.getOrDefault(ss,0) == 1)
			res.add(node);
		map.put(ss, map.getOrDefault(ss, 0) + 1);
		return ss;
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