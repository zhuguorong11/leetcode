import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mm = Integer.MAX_VALUE;
		int nn = mm + 1;
		System.out.println(mm);
		System.out.println(nn);
		int a = 123;
		int b = a;
		b = b - 1;
		System.out.println(a);
		System.out.println(b);
		String expression = "-2+33)23";
		String[] strs = expression.split("(?=[-,+,)])");
		for(String s:strs)
			System.out.println(s);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		
		
		Map<Integer, int[]> map = new HashMap<>();
		int[] nums = {1,2,3,4};
		map.put(1, nums);
		int[] aa = map.get(1);
		for(int i : aa)
			System.out.println(i);
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(4);
		queue.add(5);
		queue.add(1);
		System.out.println(queue.poll());
	}
	
}
