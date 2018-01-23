//Sort a linked list using insertion sort.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode res = new ListNode(0);
		ListNode copyRes = res;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			// save next node
			next = cur.next;
			// compare the val of pre to cur
			while (copyRes.next != null && copyRes.next.val < cur.val)
				copyRes = copyRes.next;

			// insert cur Node into res list
			cur.next = copyRes.next;
			copyRes.next = cur;

			// begin from head
			copyRes = res;
			cur = next;
		}
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