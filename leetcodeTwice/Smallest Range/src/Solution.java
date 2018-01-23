import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest
 * range that includes at least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c
 * if b-a == d-c.
 * 
 * Example 1: Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] Output: [20,24]
 * Explanation: List 1: [4, 10, 15, 24,26], 24 is in range [20,24]. List 2: [0,
 * 9, 12, 20], 20 is in range [20,24]. List 3: [5, 18, 22, 30], 22 is in range
 * [20,24].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] smallestRange(List<List<Integer>> nums) {
		// use priorityQueue
		PriorityQueue<Element> queue = new PriorityQueue<>(new Comparator<Element>() {
			public int compare(Element o1, Element o2) {
				return o1.value - o2.value;
			}
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Element element = new Element(i, 0, nums.get(i).get(0));
			queue.offer(element);
			max = Math.max(max, nums.get(i).get(0));// initial
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (queue.size() == nums.size()) {// must have the equal length
			Element cur = queue.poll();
			if (max - cur.value < range) {
				range = max - cur.value;
				start = cur.value;
				end = max;
			}
			if(cur.indexOfArray + 1 < nums.get(cur.row).size()){//means that there still has num of this array
				cur.indexOfArray = cur.indexOfArray + 1;
				cur.value = nums.get(cur.row).get(cur.indexOfArray);
				queue.offer(cur);
				if(cur.value > max)
					max = cur.value;
			}
		}
		return new int[]{start, end};
	}
}

class Element {
	int value;
	int indexOfArray;
	int row;

	public Element(int row, int index, int value) {
		this.row = row;
		this.indexOfArray = index;
		this.value = value;
	}
}