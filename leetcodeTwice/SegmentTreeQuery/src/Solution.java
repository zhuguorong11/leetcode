import java.util.ArrayList;
import java.util.List;

/**
 * 构建线段数 给定一个整数数组（下标由 0 到 n-1，其中 n 表示数组的规模），以及一个查询列表。每一个查询列表有两个整数 [start, end]。
 * 对于每个查询，计算出数组中从下标 start 到 end 之间的数的最小值，并返回在结果列表中。
 * 
 * 注意事项
 * 
 * 在做此题前，建议先完成以下三道题 线段树的构造， 线段树的查询 及 线段树的修改。
 * 
 * 样例
 * 
 * 对于数组 [1,2,7,8,5]， 查询 [(1,2),(0,4),(2,4)]，返回 [2,1,5]
 * 
 * 挑战
 * 
 * 每次查询在O(logN)的时间内完成
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
		// 构建了一棵树
		SegmentTreeNode root = build(0, nums.length - 1, nums);
		// 开始进行遍历
		for (int i = 0; i < quries.size(); ++i) {
			res.add(query(root, quries.get(i).start, quries.get(i).end));
		}
		return res;
	}

	//构建线段树
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

	//遍历
	public int query(SegmentTreeNode root, int start, int end) {
		int mid = root.start + (root.end - root.start) / 2;
		//区间包裹了
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
	//因为查找的是最小值，所以增加一个min的属性，表示该start-end区间内的最小值
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