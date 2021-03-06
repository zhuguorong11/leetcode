import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Examples: "()())()" -> ["()()()", "(())()"] "(a)())()" -> ["(a)()()",
 * "(a())()"] ")(" -> [""]
 * 
 * @author zhugr
 *
 */
public class Soluion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if(s == null || s.length() == 0){
			res.add("");
			return res;
		}
		help(s, res, 0, 0, new char[]{'(', ')'});
		return res;
	}
	public void help(String s, List<String> list, int leftPos, int rightPos, char[] par){
		for(int i = leftPos, stack = 0; i < s.length(); ++i){
			if(s.charAt(i) == par[0]){
				/*字符是"("*/
				++stack;
			}
			if(s.charAt(i) == par[1]){
				/*字符是")"*/
				--stack;
			}
			if(stack >= 0){
				/*说明此时(的数量大于等)*/
				continue;
			}
			/*此时)的数量多余(*/
			for (int j = rightPos; j <= i; ++j) {
				/*如果有连续连个都是)， 为了避免各删除后重复， 所以规定删除第一个*/
				if(s.charAt(j) == par[1] && (j == rightPos || s.charAt(j - 1) != par[1])){
					help(s.substring(0,j) + s.substring(j + 1, s.length()), list, i, j, par);
				}
			}
			return; 
		}
		/*上述处理的是)多于(的时候
		 *把字符串反转后， 就可以处理(多于)的情况
		 * */
		String reverseString = new StringBuilder(s).reverse().toString();
		if(par[0] == '('){
			/*需要check the reversed string*/
			help(reverseString, list, 0, 0, new char[]{')', '('});
		}else{
			/*have checked both ordered and reverse ordered*/
			list.add(reverseString);
		}
	}
}
