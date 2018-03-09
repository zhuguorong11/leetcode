/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode p = lists[0];
		for (int i = 1; i < lists.length; ++i) {
			p = merge(p, lists[i]);
		}
		return p;
	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode h = new ListNode(-1);
		ListNode tmp = h;
		while (left != null && right != null) {
			if (left.val < right.val) {
				tmp.next = left;

				left = left.next;
			} else {
				tmp.next = right;
				// tmp=tmp.next;
				right = right.next;
			}
			tmp = tmp.next;
		}
		if (left != null) {
			tmp.next = left;
		}
		if (right != null) {
			tmp.next = right;
		}
		return h.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}