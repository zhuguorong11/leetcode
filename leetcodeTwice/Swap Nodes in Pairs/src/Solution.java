/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode preCopy = pre;
		while (pre.next != null && pre.next.next != null) {
			ListNode next = pre.next;
			ListNode nextStart = pre.next.next.next;
			pre.next = pre.next.next;
			pre.next.next = next;
			pre.next.next.next = nextStart;
			pre = next;
		}
		return preCopy.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}