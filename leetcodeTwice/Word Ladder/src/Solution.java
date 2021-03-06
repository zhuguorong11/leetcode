import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> hasReached = new HashSet<>();
		Set<String> wordDict = new HashSet<>();
		wordDict.addAll(wordList);
		hasReached.add(beginWord);
		wordDict.add(endWord);
		int resDis = 1;
		while (!hasReached.contains(endWord)) {
			/* 保存这一轮遍历的时候新产生的符合要求的字符串 */
			Set<String> hasToAdd = new HashSet<>();
			for (String word : hasReached) {
				for (int i = 0; i < word.length(); ++i) {
					char[] chs = word.toCharArray();
					for (int j = 0; j < 26; ++j) {
						chs[i] = (char) ('a' + j);
						String afterReplace = new String(chs);
						if (wordDict.contains(afterReplace)) {
							hasToAdd.add(afterReplace);
							wordDict.remove(afterReplace);
						}
					}
				}
			}
			++resDis;
			/* 说明中间有一个过渡没有成功 */
			if (hasToAdd.size() == 0) {
				return 0;
			}
			/* 从已经到达的字符串中进行遍历下一轮 */
			hasReached = hasToAdd;
		}
		return resDis;
	}
}
