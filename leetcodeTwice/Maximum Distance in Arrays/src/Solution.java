import java.util.List;

/*
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDistance(List<List<Integer>> arrays) {
		int len = arrays.size();
		if (len == 0)
			return 0;
		int res = Integer.MIN_VALUE;
		//初始化
		int max = arrays.get(0).get(arrays.get(0).size() - 1);// 最大值
		int min = arrays.get(0).get(0);// 最小值
		for (int i = 1; i < len; ++i) {
			res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
			res = Math.max(res, Math.abs(arrays.get(i).get(0) - max));

			max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
			min = Math.min(min, arrays.get(i).get(0));
		}
		return res;
	}
}
