
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("null")
	public int majorityElement(int[] nums) {
		if(nums.length == 0|| nums == null)
			return (Integer) null;
		int j = 0;//用来计数
		int k = 0;//用来记录主要元素
		for(int i = 0; i < nums.length; ++i)
		{
			if(j == 0)
				k = nums[i];
			if(k == nums[i])
				++j;
			else
				--j;
		}
		return k;
	}
}
