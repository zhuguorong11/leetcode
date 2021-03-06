/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode p1 = new ListNode(0);// smaller than x
		ListNode p2 = new ListNode(0);// equal or larger than x
		ListNode pre1 = p1;
		ListNode pre2 = p2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}
		p2.next = null;
		p1.next = pre2.next;
		return pre1.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}