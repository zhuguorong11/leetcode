import java.util.Arrays;

/**
 * �����������������飨��һ�������� A���ڶ��������� B���������� A ��ȡ A[ i ]������ B ��ȡ B[ j ]��A[ i ] �� B[ j ]
 * ���ߵĲ�ԽСԽ��( | A[ i ] - B[ j ] | )��дһ������������С�
 * 
 * ��ս �� ʱ�临�Ӷ� O(n log n)
 * 
 * ��ʽ��
 * 
 * ���������������������� A �� B�����������ص���С�
 * 
 * ��������
 * 
 * A = [ 3��4��6��7 ] B = [ 2��3��8��9 ]
 * 
 * �������
 * 
 * 0
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[] A = { 3,4,6,7 };
				int[] B = { 4,8,9 };
				System.out.println(Solution.minimumDiff(A, B));
	}

	public static int minimumDiff(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return 0;
		}
		Arrays.sort(nums2);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums1.length; ++i) {
			int begin = 0, end = nums2.length - 1;
			int mid = 0;
			int target = nums1[i];
			while (begin <= end) {
				mid = begin + (end - begin) / 2;
				if (nums2[mid] == target) {
					return 0;
				} else if (nums2[mid] > target) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}
			res = Math.min(res, Math.abs(nums1[i] - nums2[mid]));
			// mid�����������ٱȽ�һ��
			if (mid > 0) {
				Math.min(res, Math.abs(nums1[i] - nums2[mid - 1]));
			}
			if (mid < nums2.length - 1) {
				Math.min(res, Math.abs(nums1[i] - nums2[mid + 1]));
			}
		}
		return res;
	}
}