//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		return linkToBST(head, null);
	}
	//find middle node
	public TreeNode linkToBST(ListNode start,ListNode end){
		ListNode slow = start;
		ListNode fast = start;
		//the condition of finish
		if(start == end)
			return null;
		while(fast != end && fast.next != end){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = linkToBST(start, slow);
		node.right = linkToBST(slow.next, end);
		return node;
	}
}
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
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