/*
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3};
		int[] nums2 = {4,5,6};
		System.out.println(Solution.findMedianSortedArrays(nums1, nums2));
	}

	// һ�ַ����Ƕ�һ���µ����飬Ȼ������һ�������飬���ǿռ临�Ӷȸߣ�����ʱ�临�Ӷ�Ҳ��
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int[] arrNew = new int[len1 + len2];
		int s1 = 0;// nums1��λ��
		int s2 = 0;// nums2��λ��
		int len = arrNew.length;
		for (int i = 0; i < len; ++i) {
			if ((s2 >= len2) || (s1 < len1 && nums1[s1] < nums2[s2])) {
				arrNew[i] = nums1[s1];
				++s1;
			} else {
				arrNew[i] = nums2[s2];
				++s2;
			}
		}
		// ż����
		if (len % 2 == 0)
			return (arrNew[len / 2 - 1] + arrNew[len / 2]) / 2.0;
		else
			return arrNew[len / 2];
	}

	// ��һ�ַ�����ͨ����ԭ������
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int i = 0, j = 0;// �ֱ�ָ���������������λ��
		int midPointer = 0;// �м�λ��
		
		//����ֻҪ����һ����������� 
		for (i = 0, j = 0; midPointer <= (len1 + len2) >> 1; ++midPointer) {
			if (i >= len1)
				++j;
			else if (j >= len2)
				++i;
			else if (nums1[i] >= nums2[j])
				++j;
			else
				++i;
		}
		boolean isEven = (len1 + len2) % 2 == 0 ? true : false;// �жϸ����Ƿ�Ϊż��
		--i;
		--j;// ��Ϊ�����Ǵ�0��ʼ����
		// �ж�nums1��nums2�Ƿ��п����飬Ҳ������߽��������len1 = 1,len2 = 0;
		if (i < 0)
			return isEven ? (nums2[j - 1] + nums2[j]) / 2.0 : nums2[j];
		if (j < 0)
			return isEven ? (nums1[i - 1] + nums1[i]) / 2.0 : nums1[i];
		// ���ܸ���Ϊ������ʱ��
		if (!isEven) {
			return Math.max(nums1[i], nums2[j]);
		} else {
			// �ܸ���Ϊż����ʱ��
			if (nums1[i] < nums2[j]) {
				if (j - 1 >= 0 && nums1[i] < nums2[j - 1])
					return (nums2[j] + nums2[j - 1]) / 2.0;
				return (nums2[j] + nums1[i]) / 2.0;
			} else {
				if (i - 1 >= 0 && nums2[j] < nums1[i - 1])
					return (nums1[i] + nums1[i - 1]) / 2.0;
				return (nums2[j] + nums1[i]) / 2.0;
			}
		}

	}
}
