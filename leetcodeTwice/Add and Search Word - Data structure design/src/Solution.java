/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class WordDictionary {

	/** Initialize your data structure here. */
	public Node root;

	public WordDictionary() {
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		insert(word, root);
	}

	public void insert(String word, Node root) {
		char[] chs = word.toCharArray();
		int len = chs.length;
		for (int i = 0; i < len; ++i) {
			/* �����a����ĸ���±� */
			int index = chs[i] - 'a';
			if (root.childs[index] != null) {
				/* ��ʾ���±��Ѿ���ֵ�˵ģ������Դ�Ϊǰ׺���ִ���++ */
				root.childs[index].prefix_num++;
			} else {
				/* ��ʾ�������� */
				root.childs[index] = new Node();
				root.childs[index].prefix_num++;
			}
			/* ��������ַ���word�Ľ�β��������� */
			if (i == len - 1) {
				root.childs[index].isLeaf = true;
				/* ���ַ���word���ظ���Ŀ++ */
				root.childs[index].dumpli_num++;
			}
			/* ָ���ӽڵ㣬������������������ */
			root = root.childs[index];
		}
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 * 
	 * @param root
	 */
	public boolean search(String word) {
		return searchWord(word, 0, root);
	}

	public boolean searchWord(String string, int index, Node parent) {
		if (index == string.length()) {
			if (parent.isLeaf) {
				return true;
			}
			return false;
		}
		char[] chs = string.toCharArray();
		Node[] childNodes = parent.childs;
		char c = chs[index];
		/*important*/
		if (c == '.') {
			for (int i = 0; i < childNodes.length; i++) {
				Node n = childNodes[i];
				if (n != null) {
					boolean b = searchWord(string, index + 1, n);
					if (b) {
						return true;
					}
				}
			}
			return false;
		}
		Node node = childNodes[c - 'a'];
		if (node == null) {
			return false;
		}
		return searchWord(string, ++index, node);
	}
}

class Node {
	public int dumpli_num;//// ���ִ����ظ���Ŀ�� ������ͳ���ظ�������ʱ������,ȡֵΪ0��1��2��3��4��5����
	public int prefix_num;/// �Ը��ִ�Ϊǰ׺���ִ����� Ӧ�ð������ִ�������������
	public Node childs[];//// �˴�������ʵ�֣���ȻҲ����map��listʵ���Խ�ʡ�ռ�
	public boolean isLeaf;/// �Ƿ�Ϊ���ʽڵ�

	public Node() {
		dumpli_num = 0;
		prefix_num = 0;
		isLeaf = false;
		childs = new Node[26];
	}
}