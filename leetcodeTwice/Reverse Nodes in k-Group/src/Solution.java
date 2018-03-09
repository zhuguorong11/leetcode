/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode cur = head;
		while(cur != null && count != k){
			++count;
			cur = cur.next;
		}
		//������ҵ�k+1���ڵ㣬������cur�ǵ�k+1����
		if(count == k){
			cur = reverseKGroup(cur, k);
			//����head��ʾ������������µ�һ��group���ͷ���
			//  cur��ʾ���Ƿ�ת��Ľڵ�
			while(count-- > 0){
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
			}
			head = cur;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}