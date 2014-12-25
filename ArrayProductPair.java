import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class ArrayProductPair {

	public static ArrayList<int []> findPairs(int []arr,int k){
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		ArrayList<int []> pairs = new ArrayList<int[]>();
		int len = arr.length;

		for (int i = 0 ; i < len ; i++) {
			map.put(arr[i],true);
		}

		int a,b;
		for (int i = 0 ; i < len ; i++) {
			a = arr[i];
			b = k / arr[i];
			if (k % a == 0 && map.get(b) != null && map.get(b) != false) {
				int [] pair = {a,b};
				pairs.add(pair);
				map.put(a,false);
				map.put(b,false);
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		ArrayList<int []> pairs = findPairs(arr,12);
		System.out.println(pairs);
		for (int []pair : pairs ) {
			System.out.println(Arrays.toString(pair));
		}
	}
}