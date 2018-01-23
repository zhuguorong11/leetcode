import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor. For
 * example, the root an, followed by other, which can form another word another.
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * You need to output the sentence after the replacement.
 * 
 * Example 1: Input: dict = ["cat", "bat", "rat"] sentence =
 * "the cattle was rattled by the battery" Output: "the cat was rat by the bat"
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public String replaceWords(List<String> dict, String sentence) {
		if (dict.size() == 0)
			return sentence;
		Set<String> set = new HashSet<>();
		for (String string : dict)
			set.add(string);
		String[] words = sentence.split("\\s+");
		StringBuilder sBuilder = new StringBuilder();
		for (String word : words) {
			String root = "";
			for (int i = 0; i <= word.length(); ++i) {
				root = word.substring(0, i);
				if (set.contains(root)) {
					break;
				}
			}
			sBuilder.append(" " + root);
		}
		sBuilder = sBuilder.deleteCharAt(0);
		return sBuilder.toString();
	}
}
