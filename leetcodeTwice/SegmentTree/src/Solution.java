/**
 * �����߶���
 * �߶�����һ�ö�����������ÿ���ڵ�������������������start��end���ڱ�ʾ�ýڵ�����������䡣start��end�������������������µķ�ʽ��ֵ:
 * 
 * ���ڵ�� start �� end �� build ������������ ���ڽڵ� A ������ӣ��� start=A.left, end=(A.left +
 * A.right) / 2�� ���ڽڵ� A ���Ҷ��ӣ��� start=(A.left + A.right) / 2 + 1, end=A.right�� ���
 * start ���� end, ��ô�ýڵ���Ҷ�ӽڵ㣬���������Ҷ��ӡ�
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public SegmentTreeNode build(int start, int end) {
		if (start > end) {
			return null;
		}
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start != end) {
			root.left = build(start, (start + end) / 2);
			root.right = build((start + end) / 2 + 1, end);
		}
		return root;
	}
}

class SegmentTreeNode {
	int start, end;
	SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = null;
		this.right = null;
	}
}