/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 不实用额外的空间，则需要从nums1的后面开始加入
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i > -1 && j > -1) {
			nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
		}
		while (j > -1)
			nums1[k--] = nums2[j--];
	}
}
