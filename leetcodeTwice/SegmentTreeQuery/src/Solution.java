import java.util.ArrayList;
import java.util.List;

/**
 * �����߶��� ����һ���������飨�±��� 0 �� n-1������ n ��ʾ����Ĺ�ģ�����Լ�һ����ѯ�б�ÿһ����ѯ�б����������� [start, end]��
 * ����ÿ����ѯ������������д��±� start �� end ֮���������Сֵ���������ڽ���б��С�
 * 
 * ע������
 * 
 * ��������ǰ��������������������� �߶����Ĺ��죬 �߶����Ĳ�ѯ �� �߶������޸ġ�
 * 
 * ����
 * 
 * �������� [1,2,7,8,5]�� ��ѯ [(1,2),(0,4),(2,4)]������ [2,1,5]
 * 
 * ��ս
 * 
 * ÿ�β�ѯ��O(logN)��ʱ�������
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> intervalMinNumber(int[] nums, List<Interval> quries) {
		if (nums.length == 0 || quries.isEmpty()) {
			return new ArrayList<>();
		}	
		List<Integer> res = new ArrayList<>();
		// ������һ����
		SegmentTreeNode root = build(0, nums.length - 1, nums);
		// ��ʼ���б���
		for (int i = 0; i < quries.size(); ++i) {
			res.add(query(root, quries.get(i).start, quries.get(i).end));
		}
		return res;
	}

	//�����߶���
	public SegmentTreeNode build(int start, int end, int[] nums) {
		if (start > end) {
			return null;
		}
		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
		if (start != end) {
			root.left = build(start, (start + end) / 2, nums);
			root.right = build((start + end) / 2 + 1, end, nums);
			root.min = Math.min(root.left.min, root.right.min);
		} else {
			root.min = nums[start];
		}
		return root;
	}

	//����
	public int query(SegmentTreeNode root, int start, int end) {
		int mid = root.start + (root.end - root.start) / 2;
		//���������
		if (start <= root.start && end >= root.end) {
			return root.min;
		} else if (mid < start) {
			return query(root.right, start, end);
		} else if (mid + 1 > end) {
			return query(root.left, start, end);
		} else {
			return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
		}
	}
}

class SegmentTreeNode {
	//��Ϊ���ҵ�����Сֵ����������һ��min�����ԣ���ʾ��start-end�����ڵ���Сֵ
	int start, end, min;
	SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int min) {
		this.start = start;
		this.end = end;
		this.min = min;
		this.left = null;
		this.right = null;
	}
}

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}