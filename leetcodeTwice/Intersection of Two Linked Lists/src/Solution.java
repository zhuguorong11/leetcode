/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A:     	   a1 ¡ú a2
                   		¨K
                          c1 ¡ú c2 ¡ú c3
                   		¨J            
   B:     b1 ¡ú b2 ¡ú b3
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lenA = getListLen(headA);
		int lenB = getListLen(headB);
		while (lenA > lenB) {
			headA = headA.next;
			--lenA;
		}
		while (lenA < lenB) {
			headB = headB.next;
			--lenB;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	public int getListLen(ListNode node) {
		int len = 0;
		while (node != null) {
			++len;
			node = node.next;
		}
		return len;
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