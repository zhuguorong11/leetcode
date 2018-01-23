
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Trie {

	/** Initialize your data structure here. */
	public Node root;

	public Trie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
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

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean search(String word, Node root) {
		char[] chs = word.toLowerCase().toCharArray();
		for (int i = 0, length = chs.length; i < length; i++) {
			int index = chs[i] - 'a';
			if (root.childs[index] == null) {
				/// 如果不存在，则查找失败
				return false;
			}
			root = root.childs[index];
		}
		if(root.isLeaf){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		return startsWith(prefix, root);
	}

	public boolean startsWith(String prefix, Node root) {
		char[] chrs = prefix.toLowerCase().toCharArray();
		StringBuilder sBuilder = new StringBuilder(prefix);
		////
		for (int i = 0, length = chrs.length; i < length; i++) {

			int index = chrs[i] - 'a';
			if (root.childs[index] == null) {
				return false;
			}
			sBuilder = sBuilder.deleteCharAt(0);
			root = root.childs[index];
			
		}
		if(sBuilder.length() == 0){
			return true;
		}else{
			return false;
		}
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