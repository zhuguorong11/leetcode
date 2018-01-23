/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		// find the last node use fastNode
		ListNode fast = head;
		int len = 1;
		while (fast.next != null) {
			fast = fast.next;
			++len;
		}
		// find the right by k + 1 places use slowNode
		ListNode slow = head;
		// maybe k > len, so we should use k % len
		for (int i = 1; i <= (len - k % len) - 1; ++i) {
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}