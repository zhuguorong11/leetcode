import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note: If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a single string.
 * FExample 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findItinerary(String[][] tickets) {
		// use priorityQueue
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		LinkedList<String> reStrings = new LinkedList<>();
		for (int i = 0; i < tickets.length; ++i) {
			if (!map.containsKey(tickets[i][0]))
				map.put(tickets[i][0], new PriorityQueue<>());
			map.get(tickets[i][0]).add(tickets[i][1]);
		}
		// use stack to store the last place,and use this last place as the start place of next plan
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		while (!stack.isEmpty()) {
			// whether map contains the key of the top of the stack,and the value of this key is not empty
			while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
				// then we should get the first string from priorityqueue and put it into stack as the start of next plan
				stack.push(map.get(stack.peek()).poll());
			reStrings.addFirst(stack.pop());
		}
		return reStrings;
	}
}
