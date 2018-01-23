/*
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of array A is an integer within the range [0, N-1].
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayNesting(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		boolean[] visited = new boolean[len];
		for (int i = 0; i < len; i++) {
			// 如果起始的位置已经被先前访问过了，那么这一次的长度肯定小于之前，就可以跳过了
			if (visited[i])
				continue;
			int count = dfs(nums, i, visited);
			max = Math.max(max, count);
		}
		return max;
	}

	public int dfs(int[] nums, int start, boolean[] visited) {
		int count = 1;// 自己本身就是一个情况，初始为1
		int val = nums[start];
		while (val != start) {
			val = nums[val];
			visited[val] = true;
			++count;
		}
		return count;
	}
}
