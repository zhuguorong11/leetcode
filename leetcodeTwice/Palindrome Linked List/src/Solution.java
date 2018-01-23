/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		if(head == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null  && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		//judge the length of list
		if(fast != null)//odd
			slow = slow.next;
		
		//reverse list begin from slow
		slow = reverseList(slow);
		while(slow != null && slow.val == head.val)
		{
			slow = slow.next;
			head = head.next;
		}
		return slow == null;
	}

	public ListNode reverseList(ListNode head) {
		ListNode newhead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			head = next;
		}
		return newhead;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}