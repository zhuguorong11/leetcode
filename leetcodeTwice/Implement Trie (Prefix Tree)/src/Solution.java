
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

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean search(String word, Node root) {
		char[] chs = word.toLowerCase().toCharArray();
		for (int i = 0, length = chs.length; i < length; i++) {
			int index = chs[i] - 'a';
			if (root.childs[index] == null) {
				/// ��������ڣ������ʧ��
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