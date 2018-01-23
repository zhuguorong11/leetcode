/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode preCopy = pre;
		int len = getListLen(head);
		if(len == 1 && n == 1)
			return null;
		for (int i = 1; i <= len - n; ++i)
			pre = pre.next;
		pre.next = pre.next.next;
		return preCopy.next;
	}

	public int getListLen(ListNode node) {
		int count = 0;
		while (node != null) {
			node = node.next;
			++count;
		}
		return count;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}