
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		if(head == null)
			return null;
		ListNode newNode = null;
		while(head != null){
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