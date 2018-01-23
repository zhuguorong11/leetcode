import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: ¡°a tree is an undirected graph in which any two vertices are 
connected by exactly one path. In other words, any connected graph without simple cycles is a tree.¡±
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int edges[][] = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		int edges2[][] = {{0,1},{0,2},{0,3},{1,4}};
		System.out.println(solution.validTree(5, edges));
	}
	
	//use dfs
	boolean[] visited;
	boolean isTree = true;
	int nodeCount = 0;
	public boolean validTree(int n, int[][] edges) {  
		if(edges.length < n - 1)
			return false;
		visited = new boolean[n];
		List<Integer>[] graph = new List[n];
		for(int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();
		for(int[] edge : edges){
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		dfs(-1, 0, graph);	
		return isTree && nodeCount == n;
	}
	public void dfs(int pre, int cur, List<Integer>[] graph)
	{
//		if(!isTree)
//			return;
		if(visited[cur]){
			isTree = false;
			return;
		}
		visited[cur] = true;
		++nodeCount;
		for(int next : graph[cur]){
			if(next == pre)
				continue;
			dfs(cur, next, graph);
//			if(!isTree)
//				return;
		}
	}
}
