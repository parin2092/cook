import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problem4 {
	public static int[] process(int n,int[] arr){
		LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<Integer,Integer>();
		int maxc = 0;
		int maxe = 200000;

		for(int i = 0 ; i < n ; i++){
			int elem = arr[i];
			int nc = 1;
			if (cache.containsKey(elem)) {
				nc = cache.get(elem)+1;
				cache.put(elem,nc);
			}else{
				cache.put(elem,nc);
			}
			if ((nc == maxc && elem < maxe) || (nc > maxc)) {
				maxc = nc;
				maxe = elem;
			}
		}
		int ans[] = new int[2];
		ans[0] = maxe;
		ans[1] = maxc;
		return ans;
	}
    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );
        int tc = in.nextInt( );
        int ans[][] = new int[tc][2];

        for(int i = 0 ; i < tc;i++){
        	int n = in.nextInt();
        	int arr[] = new int[n];
        	for(int j = 0 ; j < n ; j++){
        		arr[j] = in.nextInt();
        	}
        	ans[i] = process(n,arr);
        }
        for(int i = 0 ; i < tc;i++){
        	System.out.println("" + ans[i][0] + " "+ ans[i][1]);
        }
    }

}