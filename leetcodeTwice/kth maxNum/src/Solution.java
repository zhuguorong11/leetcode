import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] num = { 22, 13, 25, 32, 11, 68, 72, 33, 42, 90 };
		ArrayList<Integer> res = solution.search(num, 5);
		System.out.println(res);
	}

	public ArrayList<Integer> search(int[] num, int k) {
		ArrayList<Integer> aList = new ArrayList<>();
		if (num.length == 0 || k > num.length || k <= 0)
			return aList;
		int low = 0;
		int high = num.length - 1;
		int index = partition(num, k, low, high);
		//k位置前进行排序
		while (index != k - 1) {
			if (index > k - 1) {
				high = index - 1;
				index = partition(num, k, low, high);
			} else {
				low = index + 1;
				index = partition(num, k, low, high);
			}
		}
		for (int i = 0; i < k; i++)
			aList.add(num[i]);
		return aList;
	}

	public int partition(int[] num, int k, int low, int high) {
		int tmp = num[k - 1];
		swap(num,k-1,low);
		while (low < high) {
			while (low < high && num[high] >= tmp) {
				--high;
			}
			swap(num, low, high);
			while (low < high && num[low] <= tmp) {
				++low;
			}
			swap(num, low, high);
		}
		return low;
	}

	//第k个数
	int quicksort(int l, int r, int k){
	    int pos = part(l,r);
	    if(pos - l + 1 == k) 
	    	return a[pos];
	    else if(pos - l + 1> k) 
	    	return quicksort(l,pos-1,k);
	    else 
	    	return quicksort(pos+1,r,k-(pos-l+1));
	}

	public void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}
