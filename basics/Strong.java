import java.io.*;
import java.util.*;

public class Strong {
	public static void hit(int[] arr,int x){
		for(int i = 0 ; i < arr.length ; i++){
			if (arr[i] > x) {
				arr[i] -= 1;
			}
		}
	}
    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );

        int tc = in.nextInt();
        int ans[] = new int[tc];

        for(int t = 0 ; t < tc; t++){
	        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
            int n = in.nextInt( );
            int m = in.nextInt( );
            for (int i = 0 ; i < n ;i++ ) {
                map.put(in.nextInt(),1);
            }
            for (int i = 0 ; i < m ;i++ ) {
            	int elem = in.nextInt();
            	if (map.containsKey(elem)) {
            		map.put(elem,map.get(elem)+1);
            	}else{
            		map.put(elem,1);
            	}
            }
            int strenght = 0;
            for(Integer key  : map.keySet()){
            	if (map.get(key) > 1) {
            		strenght++;
            	}
            }
            ans[t] = strenght;
        }
        for(int t = 0 ; t<tc;t++){
            System.out.println(ans[t]);
        }
    }
}
