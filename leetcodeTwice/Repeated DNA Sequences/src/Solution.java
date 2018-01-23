import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> map = new HashMap<>();
		List<String> res = new ArrayList<>();
		int len = s.length();
		if (s == null || s.length() == 0)
			return res;
		for (int i = 0; i <= (len - 10); ++i) {
			String str = s.substring(i, i + 10);
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int times = map.get(key);
			if (times > 1)
				res.add(key);
		}
		return res;
	}
}
