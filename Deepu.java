import java.io.*;
import java.util.*;

public class Deepu {
	public static void hit(int[] arr,int x){
		for(int i = 0 ; i < arr.length ; i++){
			if (arr[i] > x) {
				arr[i] -= 1;
			}
		}
	}
    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt( );
        int arr[] = new int[n];
        for (int i = 0 ; i < n ;i++ ) {
        	arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int hx[] = new int[m];
        for (int i = 0 ;i< m  ; i++) {
        	hx[i] = in.nextInt();
        }

        for (int i = 0 ; i < m; i++) {
        	hit(arr,hx[i]);
        }
        System.out.print(arr[0] );
        for(int i = 1 ; i < n ; i++){
        	System.out.print(  " " + arr[i]);
        }
    }
}