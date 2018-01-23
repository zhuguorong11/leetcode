//Compute and return the square root of x.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mySqrt(int x) {
		int res = 0;
		for (int i = 1; x > 0; i = i + 2, ++res) {
			x -= i;
		}
		return x == 0 ? res : (res - 1);
	}

	// use binary search
	public int mySqrt2(int x) {
		if (x == 0)
			return 0;
		int start = 1, end = Integer.MAX_VALUE;
		int mid = 0;
		while (true) {
			mid = start + (end - start) / 2;
			if (mid > x / mid)
				end = mid - 1;
			else {
				if (mid + 1 > x / (mid + 1))
					break;
				start = mid + 1;
			}
		}
		return mid;
	}
}
