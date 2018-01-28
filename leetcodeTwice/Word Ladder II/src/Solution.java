import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] Return [
 * ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ] Note:
 * Return an empty list if there is no such transformation sequence. All words
 * have the same length. All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dict = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<List<String>>();
		/* 用一个map来记录每一个字符串节点的邻居节点，即改变一个字母就能相等的节点 */
		HashMap<String, ArrayList<String>> neighbors = new HashMap<>();
		/* 用一个map来记录每一个字符串节点到start节点的距离 */
		HashMap<String, Integer> distances = new HashMap<>();

		dict.add(beginWord);
		bfs(beginWord, endWord, dict, neighbors, distances);
		dfs(beginWord, endWord, dict, neighbors, distances, res, new ArrayList<String>());

		return res;
	}

	/* 用bfs来构建每个节点的关系图 */
	public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, ArrayList<String>> neighbors,
			Map<String, Integer> distances) {
		/* 初始化 */
		for (String word : dict) {
			neighbors.put(word, new ArrayList<>());
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		distances.put(beginWord, 0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			/* 用isEnd来判断是否到达endWord */
			boolean isEnd = false;
			for (int i = 0; i < size; ++i) {
				String curNode = queue.poll();
				int curDistance = distances.get(curNode);
				ArrayList<String> curNeighbors = findNeighbors(curNode, dict);
				for (String neighbor : curNeighbors) {
					neighbors.get(curNode).add(neighbor);
					/* 来判断是否已经访问过 */
					if (!distances.containsKey(neighbor)) {
						distances.put(neighbor, curDistance + 1);
						if (neighbor.equals(endWord)) {
							isEnd = true;
						} else {
							queue.offer(neighbor);
						}
					}
				}
				/* 表示已经找到最短的路径 */
				if (isEnd) {
					break;
				}
			}
		}
	}

	/* 查找所有下一个节点 */
	public ArrayList<String> findNeighbors(String curNode, Set<String> dict) {
		ArrayList<String> res = new ArrayList<>();
		char[] chs = curNode.toCharArray();
		for (int i = 0; i < chs.length; ++i) {
			for (int j = 'a'; j <= 'z'; ++j) {
				if (chs[i] == j) {
					continue;
				} else {
					char temp = chs[i];
					chs[i] = (char) j;
					if (dict.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					/* 还原 */
					chs[i] = temp;
				}
			}
		}
		return res;
	}

	/* 用dfs来查找所有最短的集合 */
	public void dfs(String curNode, String endWord, Set<String> dict, Map<String, ArrayList<String>> neighbors,
			Map<String, Integer> distances, List<List<String>> res, List<String> solutions) {
		solutions.add(curNode);
		if (curNode.equals(endWord)) {
			res.add(new ArrayList<>(solutions));
		}
		for (String neighbor : neighbors.get(curNode)) {
			if (distances.get(curNode) + 1 == distances.get(neighbor)) {
				dfs(neighbor, endWord, dict, neighbors, distances, res, solutions);
			}
		}
		/* 回溯法来找其他的路径 */
		solutions.remove(solutions.size() - 1);
	}
}
