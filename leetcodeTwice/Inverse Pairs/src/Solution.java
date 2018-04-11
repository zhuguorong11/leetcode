/**
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007 ��������: ��Ŀ��֤�����������û�е���ͬ������ ���ݷ�Χ��
 * ����%50������,size<=10^4 ����%75������,size<=10^5 ����%100������,size<=2*10^5 ʾ��1 ����
 * 
 * 1,2,3,4,5,6,7,0 ���
 * 
 * 7
 */

public class Solution {

	public int InversePairs(int[] array) {
		int len = array.length;
		if (len == 0) {
			return 0;
		}
		int[] copy = new int[len];
		for (int i = 0; i < len; ++i) {
			copy[i] = array[i];
		}
		long res = merge(copy, array, 0, len - 1);
		return (int) res % 1000000007;
	}

	// ���ƹ鲢
	public long merge(int[] copy, int[] array, int start, int end) {
		if (start == end) {
			// copy[start]=array[start];
			return 0;
		}
		int mid = start + (end - start) / 2;
		long leftCount = merge(copy, array, start, mid) % 1000000007;
		long rightCount = merge(copy, array, mid + 1, end) % 1000000007;

		int i = mid;
		int j = end;
		int index = end;
		long count = 0;
		while (i >= start && j >= mid + 1) {
			if (array[i] > array[j]) {
				count += j - mid;
				copy[index--] = array[i--];
				count = count % 1000000007;
			} else {
				copy[index--] = array[j--];
			}
		}
		while (i >= start) {
			copy[index--] = array[i--];
		}
		while (j >= mid + 1) {
			copy[index--] = array[j--];
		}
		for (int s = start; s <= end; s++) {
			array[s] = copy[s];
		}
		return (count + leftCount + rightCount) % 1000000007;
	}
}