/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeElements(ListNode head, int val) {
		// remove first node if satisfy
		while (head != null && head.val == val)
			head = head.next;
		ListNode newNode = head;
		while (newNode != null && newNode.next != null) {
			if (newNode.next.val == val) {
				newNode.next = newNode.next.next;
			} else
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