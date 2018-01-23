import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains any duplicates. Your function should return true 
 * if any value appears at least twice in the array, and it should return false if every element is distinct.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;
        Set<Integer> ss = new HashSet<>();
        for(int i = 0 ; i < len;i++)
        {
        	ss.add(nums[i]);
        }
        int size = ss.size();
        
        if(len>size)
        	return true;
        else
        	return false;
	}
}
