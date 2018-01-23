import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		//build Trie
		TrieNode root = bulidTrie(words);
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; j++) {
				helper(board, res, root, i, j);
			}
		}
		return res;
	}
	public void helper(char[][] board, List<String> res, TrieNode p, int i, int j) {
		char temp = board[i][j];
		if(temp == '#' || p.next[temp - 'a'] == null)
			return;
		p = p.next[temp - 'a'];
		if(p.word != null){
			//find one
			res.add(p.word);
			p.word = null;//avoid duplicate
		}
		// make mark
		board[i][j] = '#';
		if(i > 0) helper(board, res, p, i - 1, j);
		if(i < board.length - 1) helper(board, res, p, i + 1, j);
		if(j > 0) helper(board, res, p, i, j - 1);
		if(j < board[0].length - 1) helper(board, res, p, i, j + 1);
		board[i][j] = temp;
	}
	public TrieNode bulidTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode p = root;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = word;
		}
		return root;
	}
}
class TrieNode {
	TrieNode[] next = new TrieNode[26];
	String word;
}