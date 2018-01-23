/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Now your job is to find the total Hamming distance between all pairs of the
 * given numbers.
 * 
 * Example: Input: 4, 14, 2
 * 
 * Output: 6
 * 
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is
 * 0010 (just showing the four bits relevant in this case). So the answer will
 * be: HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) =
 * 2 + 2 + 2 = 6.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int totalHammingDistance(int[] nums) {
		/*use bit count and (permutation and combination)*/
		if(nums == null){
			return 0;
		}
		int len = nums.length;
		int total = 0;
		int intBit = 32;
		for(int i = 0; i < intBit; ++i){
			int curBistOneCount = 0;
			for(int num : nums){
			curBistOneCount += (num >> i) & 1;
			}
			total += curBistOneCount * (len - curBistOneCount);
		}
		return total;
	}
}
