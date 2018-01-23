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
			/* 相对于a的字母做下标 */
			int index = chs[i] - 'a';
			if (root.childs[index] != null) {
				/* 表示该下标已经有值了的，所以以此为前缀的字串数++ */
				root.childs[index].prefix_num++;
			} else {
				/* 表示还不存在 */
				root.childs[index] = new Node();
				root.childs[index].prefix_num++;
			}
			/* 如果到了字符串word的结尾，则做标记 */
			if (i == len - 1) {
				root.childs[index].isLeaf = true;
				/* 该字符串word的重复数目++ */
				root.childs[index].dumpli_num++;
			}
			/* 指向子节点，继续按上述方法处理 */
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
	public int dumpli_num;//// 该字串的重复数目， 该属性统计重复次数的时候有用,取值为0、1、2、3、4、5……
	public int prefix_num;/// 以该字串为前缀的字串数， 应该包括该字串本身！！！！！
	public Node childs[];//// 此处用数组实现，当然也可以map或list实现以节省空间
	public boolean isLeaf;/// 是否为单词节点

	public Node() {
		dumpli_num = 0;
		prefix_num = 0;
		isLeaf = false;
		childs = new Node[26];
	}
}