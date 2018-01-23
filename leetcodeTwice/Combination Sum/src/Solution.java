import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//ÿ�������ظ�ʹ�ã�����������û���ظ���ֵ
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				temp.add(candidates[i]);
				helper(res, temp, candidates, target - candidates[i], i);// ��Ϊͬһ�����п���ʹ�ö�Σ����Ի��Ǵ�i��ʼ
				// ���ݷ�
				temp.remove(temp.size() - 1);
			}
		}
	}
}
