import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ���������п������ظ���ֵ��ÿ����ֻ����һ�Σ����ҵõ���list�в�����һ����
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), candidates, target, 0);
		// ����һ��set
		Set<List<Integer>> set = new HashSet<>();
		for (List<Integer> list : res) {
			set.add(list);
		}
		res = new ArrayList<List<Integer>>();
		res.addAll(set);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> temp, int[] candiadates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candiadates.length; i++) {
			if (candiadates[i] <= target) {
				temp.add(candiadates[i]);
				helper(res, temp, candiadates, target - candiadates[i], i + 1);
				// ����
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	//���ַ������Ӻã������˿ռ临�ӶȺ�ʱ�临�Ӷȡ�
	public void helper2(List<List<Integer>> res, List<Integer> temp, int[] candiadates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candiadates.length; i++) {
			if (candiadates[i] <= target) {
				//��ǰ������ֵ���ʱ����������ֵ
				if(i > start && candiadates[i] == candiadates[i - 1])
					continue;
				else{
					temp.add(candiadates[i]);
					helper2(res, temp, candiadates, target - candiadates[i], i + 1);
					// ����
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
	
}
