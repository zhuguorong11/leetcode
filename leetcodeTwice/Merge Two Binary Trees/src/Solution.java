/**
 * Given two binary trees and imagine that when you put one of them to cover the
 * other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * Example 1:
 * Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//		if (t1 == null && t2 == null) {
//			return null;
//		}
//		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
//		TreeNode node = new TreeNode(val);
//		TreeNode left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);//avoid null point
//		TreeNode right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
//		node.left = left;
//		node.right = right;
//		return node;
		
		//better one
		if(t1 == null)
			return t2;
		if(t2 == null)
			return t1;
		t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        t1.val += t2.val;
        return t1;
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