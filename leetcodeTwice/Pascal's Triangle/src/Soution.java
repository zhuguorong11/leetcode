import java.util.ArrayList;
import java.util.List;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * */
public class Soution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; ++i) {
			List<Integer> cur = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				if(j == 0 || j == i)
					cur.add(1);
				else{
					cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
				}
			}
			res.add(cur);
		}
		return res;
	}
}
