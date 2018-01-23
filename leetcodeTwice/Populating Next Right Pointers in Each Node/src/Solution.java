import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; } Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children). For example, Given the following perfect binary tree, 
    	1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
After calling your function, the tree should look like: 1 ->
 * NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//bsf
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return ;
		}
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
//		while (!queue.isEmpty()) {
//			TreeLinkNode cur = queue.poll();
//			if (cur.left != null) {
//				cur.left.next = cur.right;
//				if (cur.next == null)
//					cur.right.next = null;
//				else {
//					cur.right.next = cur.next.left;
//				}
//				queue.offer(cur.left);
//				queue.offer(cur.right);
//			}
//
//		}
		while(!queue.isEmpty()){
			TreeLinkNode last = null;
			int size = queue.size();
			for(int i = 0; i < size; ++i){
				TreeLinkNode cur = queue.poll();
				if(last != null)
					last.next = cur;
				last = cur;
				if(cur.left != null)
					queue.offer(cur.left);
				if(cur.right != null)
					queue.offer(cur.right);
			}
			last.next = null;
		}
	}
	
	//dfs
	public void dfs(TreeLinkNode node){
		if (node == null) {
			return ;
		}
		if(node.left != null)
			node.left.next = node.right;
		if(node.right != null && node.next != null)
			node.right.next = node.next.left;
		dfs(node.left);
		dfs(node.right);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;

	TreeLinkNode(int x) {
		val = x;
	}
}