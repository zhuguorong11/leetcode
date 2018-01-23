import java.util.Stack;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 * 
 * Example1:
 * 
 * a = 2 b = [3]
 * 
 * Result: 8 Example2:
 * 
 * a = 2 b = [1,0]
 * 
 * Result: 1024
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// (ab)%k = (a%k)(b%k)%k
	// (a^1234567%k)=(a^1234560%k)(a^7%k)%k=(a^123456%k)^10 % k (a^7%k)%k
	// let f(a,b) = a^b%k
	// f(a,1234567)=f(f(a,123456),10) * f(a,7) % k
	int base = 1337;
	public int superPow(int a, int[] b) {
		Stack<Integer> stack = new Stack<>();
		for(int num : b)
			stack.push(num);
		return superPowAgain(a, stack);
	}
	public int superPowAgain(int a,Stack<Integer> stack){
		if(stack.isEmpty())
			return 1;
		int last = stack.pop();
		return myPow(superPowAgain(a, stack), 10) * myPow(a, last) % base;
	}
	public int myPow(int a, int n) {
		a %= base;
		int res = 1;
		for (int i = 0; i < n; ++i)
			res = (res * a) % base;
		return res;
	}
}
