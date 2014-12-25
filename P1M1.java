import java.util.*;

class P1M1 {
	public static void findAll(int d,int n , int idx, int []arr){
		if (idx+1 == n ) {
			arr[idx] = d;
			System.out.println(Arrays.toString(arr));
		}else{
			arr[idx] = d;
			findAll(d+1,n,idx+1,arr);
			findAll(d-1,n,idx+1,arr);
		}
	}
	public static void main(String[] args) {
		int n = 3;
		int d = 4;
		int [] arr = new int[n];
		findAll(d,n,0,arr);
	}
}