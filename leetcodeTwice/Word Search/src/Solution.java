/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean exist(char[][] board, String word) {
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, words, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, char[] words, int wordsIndex, int i, int j) {
		// ��ʱ˵���Ѿ��ҵ�����Ҫ������
		if (wordsIndex == words.length)
			return true;
		if (i < 0 || j < 0 || i == board.length || j == board[i].length)
			return false;
		if (board[i][j] != words[wordsIndex])
			return false;

		////���е���˵����λ���ܹ��ҵ�,Ҫ����ǣ������Ѿ��ҹ�����������λ���ٻع�ͷȥ�ظ��Ը�λ�ý��в���
		char temp = board[i][j];// �����λ�õ��ַ�   �����ǹؼ�
		board[i][j] = '#';
		boolean exist = dfs(board, words, wordsIndex + 1, i + 1, j) || dfs(board, words, wordsIndex + 1, i - 1, j)
				|| dfs(board, words, wordsIndex + 1, i, j + 1) || dfs(board, words, wordsIndex + 1, i, j - 1);
		board[i][j] = temp;//�ָ����Ա���һ��ѭ����ʱ��ʹ��
		return exist;
	}
}
