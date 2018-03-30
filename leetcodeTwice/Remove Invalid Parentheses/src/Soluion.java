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
				/*�ַ���"("*/
				++stack;
			}
			if(s.charAt(i) == par[1]){
				/*�ַ���")"*/
				--stack;
			}
			if(stack >= 0){
				/*˵����ʱ(���������ڵ�)*/
				continue;
			}
			/*��ʱ)����������(*/
			for (int j = rightPos; j <= i; ++j) {
				/*�����������������)�� Ϊ�˱����ɾ�����ظ��� ���Թ涨ɾ����һ��*/
				if(s.charAt(j) == par[1] && (j == rightPos || s.charAt(j - 1) != par[1])){
					help(s.substring(0,j) + s.substring(j + 1, s.length()), list, i, j, par);
				}
			}
			return; 
		}
		/*������������)����(��ʱ��
		 *���ַ�����ת�� �Ϳ��Դ���(����)�����
		 * */
		String reverseString = new StringBuilder(s).reverse().toString();
		if(par[0] == '('){
			/*��Ҫcheck the reversed string*/
			help(reverseString, list, 0, 0, new char[]{')', '('});
		}else{
			/*have checked both ordered and reverse ordered*/
			list.add(reverseString);
		}
	}
}