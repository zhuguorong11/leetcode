//Sort a linked list in O(n log n) time using constant space complexity.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// find middle node use fast and slow node
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;// used to sperate list
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// now let pre.next = null to breake the list
		pre.next = null;

		// iteration
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// use the function of mergeTwoLists to sort
		return mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode res = new ListNode(0);
		ListNode copy = res;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				copy.next = l1;
				l1 = l1.next;
			} else {
				copy.next = l2;
				l2 = l2.next;
			}
			copy = copy.next;
		}
		if (l1 != null)
			copy.next = l1;
		if (l2 != null)
			copy.next = l2;
		return res.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}