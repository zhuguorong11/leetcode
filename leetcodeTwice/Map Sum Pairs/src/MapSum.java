import java.util.HashMap;
import java.util.Iterator;

/**
 * Implement a MapSum class with insert, and sum methods.
 * 
 * For the method insert, you'll be given a pair of (string, integer). The
 * string represents the key and the integer represents the value. If the key
 * already existed, then the original key-value pair will be overridden to the
 * new one.
 * 
 * For the method sum, you'll be given a string representing the prefix, and you
 * need to return the sum of all the pairs' value whose key starts with the
 * prefix.
 * 
 * Example 1: Input: insert("apple", 3), Output: Null Input: sum("ap"), Output:
 * 3 Input: insert("app", 2), Output: Null Input: sum("ap"), Output: 5
 * 
 * @author zhugr
 *
 */
public class MapSum {

	/** Initialize your data structure here. */
	Node root;
	
	public MapSum() {
		/// 初始化trie 树
		root = new Node();
	}

	public void insert(String key, int val) {
		insert(this.root, key, val);
	}

	public void insert(Node root, String key, int val) {
		key = key.toLowerCase();//// 转化为小写
		char[] chrs = key.toCharArray();
		int length = chrs.length;
		for (int i = 0; i < length; ++i) {
			/// 用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
			int index = chrs[i] - 'a';
			if (root.childs[index] == null) {
				root.childs[index] = new Node();
			}
			if (i == length - 1) {
				root.childs[index].isLeaf = true;
				root.childs[index].value = val;
			}
			root = root.childs[index];
		}
	}

	public int sum(String prefix) {
		int sum = 0;
		HashMap<String, Integer> map = travel(this.root,prefix, sum);
		if(map == null){
			return 0;
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			sum += map.get(key);
		}
		return sum;
	}

	public HashMap<String, Integer> travel(Node root, String prefix, int sum) {
		char[] chrs = prefix.toLowerCase().toCharArray();
		int len = chrs.length;
		for (int i = 0; i < len; ++i) {
			int index = chrs[i] - 'a';
			if (root.childs[index] == null) {
				return null;
			}
			root = root.childs[index];
		}
		return preTraversal(root, prefix, sum);
	}

	public HashMap<String, Integer> preTraversal(Node root, String prefixs, int sum) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		if (root != null) {
			if (root.isLeaf) {
				map.put(prefixs, sum + root.value);
			}
			int len = root.childs.length;
			for (int i = 0; i < len; ++i) {
				if (root.childs[i] != null) {
					char temp = (char) ('a' + i);
					String tempStr = prefixs + temp;
					map.putAll(preTraversal(root.childs[i], tempStr, sum));
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		MapSum obj = new MapSum();
		obj.insert("a", 3);
		int val = obj.sum("ap");
		System.out.println(val);
		obj.insert("b", 2);
		val = obj.sum("a");
		System.out.println(val);
	}
}

class Node {
	public boolean isLeaf;
	public int value;
	public Node childs[];

	public Node() {
		value = 0;
		isLeaf = false;
		childs = new Node[26];
	}
}
