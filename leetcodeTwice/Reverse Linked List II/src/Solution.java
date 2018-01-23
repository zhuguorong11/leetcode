/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		// find the m - 1 node
		for (int i = 0; i < m - 1; ++i)
			pre = pre.next;

		ListNode startNode = pre.next;
		ListNode startNext = startNode.next;
		for (int i = 0; i < n - m; ++i) {
			startNode.next = startNext.next;
			startNext.next = pre.next;
			pre.next = startNext;
			startNext = startNode.next;
		}
		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}