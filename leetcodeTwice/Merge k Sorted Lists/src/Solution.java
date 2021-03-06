import java.util.Comparator;
import java.util.PriorityQueue;

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

	
	//TLE
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

	// use priorityqueue
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) {
					return -1;
				} else if (o1.val > o2.val) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		ListNode res = new ListNode(0);
		ListNode copy = res;
		for(ListNode node : lists){
			if(node != null){
				queue.offer(node);
			}
		}
		while(!queue.isEmpty()){
			copy.next = queue.poll();
			copy = copy.next;
			//当为空的时候，表示来到了一个链表的末尾，那么就无需放入优先队列里进行排序了
			if(copy.next != null){
				queue.add(copy.next);
			}
		}
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