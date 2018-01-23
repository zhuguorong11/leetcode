/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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