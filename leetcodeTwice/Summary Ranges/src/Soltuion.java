import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * */
public class Soltuion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5,7};
		List<String> reStrings = Soltuion.summaryRanges(nums);
		for(String reString : reStrings)
			System.out.println(reString);
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		int len = nums.length;
		if (len == 0) {
			return res;
		}
		for (int i = 0; i < len; i++) {
			int begin = nums[i];
			while ((i + 1) < len && nums[i + 1] - nums[i] == 1) {
				++i;// �ҵ����ڲ�ֵ��Ϊ1������
			}

			// �жϸ�nums[i]�ǲ���nums[begin]����
			if (begin != nums[i]) {
				res.add(begin + "->" + nums[i]);
			} else
				res.add(begin + "");
		}
		return res;
	}
}
