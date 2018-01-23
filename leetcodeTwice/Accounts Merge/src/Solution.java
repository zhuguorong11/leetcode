import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1: Input: accounts = [["John", "johnsmith@mail.com",
 * "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John",
 * "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'], ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]] Explanation: The first and third John's are the same person
 * as they have the common email "johnsmith@mail.com". The second John and Mary
 * are different people as none of their email addresses are used by other
 * accounts. We could return these lists in any order, for example the answer
 * [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted. Note:
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		Map<String, Node> map = new HashMap<>();
		/* build graph */
		for (List<String> list : accounts) {
			for (int i = 1; i < list.size(); ++i) {
				String email = list.get(i);// because i = 0 is username
				if (!map.containsKey(email)) {
					// new node
					Node node = new Node(list.get(0), email);
					map.put(email, node);
				}

				// now connect previous email node
				if (i == 1) {
					continue;
				}
				map.get(email).neighbor.add(map.get(list.get(i - 1)));
				map.get(list.get(i - 1)).neighbor.add(map.get(email));
			}
		}

		// DFS search for each components(each account);
		Set<String> visited = new HashSet<>();
		for (String email : map.keySet()) {
			/* if means never visit before */
			if (visited.add(email)) {
				List<String> list = new ArrayList<>();
				list.add(email);
				dfs(list, visited, map.get(email));
				// sort
				Collections.sort(list);
				// add username
				list.add(0, map.get(email).username);
				res.add(list);
			}
		}
		return res;
	}

	public void dfs(List<String> list, Set<String> visited, Node root) {
		for (Node node : root.neighbor) {
			if (visited.add(node.val)) {
				list.add(node.val);
				dfs(list, visited, node);
			}
		}
	}
}

class Node {
	String username; // name
	String val; // email
	List<Node> neighbor;

	public Node(String username, String val) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.val = val;
		this.neighbor = new ArrayList<>();
	}
}
