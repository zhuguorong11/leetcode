/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
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
		if (head == null)
			return null;
		ListNode newNode = head;
		while (newNode != null && newNode.next != null) {
			if (newNode.val == newNode.next.val) {
				newNode.next = newNode.next.next;
			}else
				newNode = newNode.next;
		}
		return head;
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