/**
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 'A' : Absent. 'L' : Late. 'P' : Present. A student could be rewarded if his
 * attendance record doesn't contain more than one 'A' (absent) or more than two
 * continuous 'L' (late).
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL" Output:
 * False
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "PPALLL";
		System.out.println(Solution.checkRecord(string));
	}

	public  static boolean checkRecord(String s) {
		char[] chs = s.toCharArray();
		int Acount = 0,Lcount = 0;
		for (int i = 0; i < chs.length ; i++) {
			if (chs[i] == 'A'){
				++Acount;
				Lcount = 0;
				if(Acount == 2)
					return false;
			}			
			else if (chs[i] == 'L'){
				++Lcount;
				if(Lcount == 3)
					return false;
			}
			else
				Lcount = 0;
		}
		return true;
	}
}
