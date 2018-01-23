/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curNode = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode copyPre = pre;
		while (curNode != null ) {
			while (curNode.next != null && curNode.val == curNode.next.val) {
				curNode = curNode.next;
			}

			// judge has duplicates
			if (pre.next == curNode)
				pre = pre.next;
			else
				pre.next = curNode.next;
			curNode = curNode.next;
		}
		return copyPre.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}