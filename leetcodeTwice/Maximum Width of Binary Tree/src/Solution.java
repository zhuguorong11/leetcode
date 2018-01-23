import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. 
 * The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, 
 * but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, 
where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//use bfs
	//two queue,one is to store node,the other is to store the index of this node
	public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        	return 0;
        Queue<TreeNode> nodeStore = new LinkedList<>();
        Queue<Integer> indexStore = new LinkedList<>();
        nodeStore.offer(root);
        indexStore.offer(1);
        int max = Integer.MIN_VALUE;
        while(!nodeStore.isEmpty()){
        	int size = nodeStore.size();
        	int leftIndex = 0;
        	int rightIndex = 0;
        	for(int i = 0; i < size; ++i){
        		TreeNode curNode = nodeStore.poll();
        		int curIndex = indexStore.poll();
        		if(i == 0)
        			leftIndex = curIndex;
        		if(i == size - 1)
        			rightIndex = curIndex;
        		if(curNode.left != null)
        		{
        			nodeStore.offer(curNode.left);
        			indexStore.offer(curIndex * 2);
        		}
        		if(curNode.right != null)
        		{
        			nodeStore.offer(curNode.right);
        			indexStore.offer(curIndex * 2 + 1);
        		}
        		max = Math.max(max, rightIndex - leftIndex + 1);
        	}
        }
        return max;
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