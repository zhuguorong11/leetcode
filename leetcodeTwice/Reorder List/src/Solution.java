/**
 * Given a singly linked list L: L0��L1������Ln-1��Ln, reorder it to:
 * L0��Ln��L1��Ln-1��L2��Ln-2����
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;// used to sperate list
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null){
			pre = slow;
			slow = slow.next;		
		}
		pre.next = null;
		slow = reverseList(slow);
		while (slow != null) {
			ListNode headNext = head.next;
			ListNode slowNext = slow.next;
			head.next = slow;
			slow.next = headNext;
			head = headNext;
			slow = slowNext;
		}
	}
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode newNode = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newNode;
			newNode = head;
			head = next;
		}
		return newNode;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}