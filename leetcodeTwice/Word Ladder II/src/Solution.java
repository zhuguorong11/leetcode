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
		/* ��һ��map����¼ÿһ���ַ����ڵ���ھӽڵ㣬���ı�һ����ĸ������ȵĽڵ� */
		HashMap<String, ArrayList<String>> neighbors = new HashMap<>();
		/* ��һ��map����¼ÿһ���ַ����ڵ㵽start�ڵ�ľ��� */
		HashMap<String, Integer> distances = new HashMap<>();

		dict.add(beginWord);
		bfs(beginWord, endWord, dict, neighbors, distances);
		dfs(beginWord, endWord, dict, neighbors, distances, res, new ArrayList<String>());

		return res;
	}

	/* ��bfs������ÿ���ڵ�Ĺ�ϵͼ */
	public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, ArrayList<String>> neighbors,
			Map<String, Integer> distances) {
		/* ��ʼ�� */
		for (String word : dict) {
			neighbors.put(word, new ArrayList<>());
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		distances.put(beginWord, 0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			/* ��isEnd���ж��Ƿ񵽴�endWord */
			boolean isEnd = false;
			for (int i = 0; i < size; ++i) {
				String curNode = queue.poll();
				int curDistance = distances.get(curNode);
				ArrayList<String> curNeighbors = findNeighbors(curNode, dict);
				for (String neighbor : curNeighbors) {
					neighbors.get(curNode).add(neighbor);
					/* ���ж��Ƿ��Ѿ����ʹ� */
					if (!distances.containsKey(neighbor)) {
						distances.put(neighbor, curDistance + 1);
						if (neighbor.equals(endWord)) {
							isEnd = true;
						} else {
							queue.offer(neighbor);
						}
					}
				}
				/* ��ʾ�Ѿ��ҵ���̵�·�� */
				if (isEnd) {
					break;
				}
			}
		}
	}

	/* ����������һ���ڵ� */
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
					/* ��ԭ */
					chs[i] = temp;
				}
			}
		}
		return res;
	}

	/* ��dfs������������̵ļ��� */
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
		/* ���ݷ�����������·�� */
		solutions.remove(solutions.size() - 1);
	}
}
