import java.util.Arrays;

/**
 * ����һ�������������͸����������飬�������г�һ����������������顣дһ������ʵ�ִ˹��ܡ�
 * 
 * ע����� ����Ҫ�������������߸�����ԭ����˳��
 * 
 * ��ս�� ԭ����ɣ�û�ж���Ŀռ�
 * 
 * ��ʽ��
 * 
 * �����һ������һ��ԭʼ���飬�������������к�����顣
 * 
 * ��������
 * 
 * [ -1��-2��-3��4��5��6 ] �������
 * 
 * [ -1��5��-2��4��-3��6 ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-2,-3,4,5,6,3};
		Solution solution = new Solution();
		solution.reRange(nums);
		for(int num : nums){
			System.out.print(num + " ");
		}
	}

	public void reRange(int[] nums) {
		/* sort firts to make negative numbers leading */
		Arrays.sort(nums);
		int len = nums.length;
		int negative = 1;
		int positive = len - 2;
		if ((len & 1) == 1) {
			if (nums[len / 2] < 0) {
				swap(nums, len / 2, len - 1);
				negative = 1;
				positive = len - 3;
			} else {
				swap(nums, len / 2, 0);
				negative = 2;
				positive = len - 2;
			}
		}
		while (negative < positive) {
			swap(nums, negative, positive);
			negative += 2;
			positive -= 2;
		}
	}

	public void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
