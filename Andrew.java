import java.io.*;
import java.util.*;

public class Andrew {
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
        long ans[] = new long[tc];

        for(int t = 0 ; t < tc; t++){
            int n = in.nextInt( );

            int building[] = new int[n];
            for (int i = 0 ; i < n ;i++ ) {
                building[i] = in.nextInt();
            }
            int highestRight[] = new int[n];
            int highestLeft[] = new int[n];
            highestLeft[0] = building[0];
            highestRight[n-1] = building[n-1];

            for (int i = 1; i < n; i++) {
                highestLeft[i] = Math.max(building[i],highestLeft[i-1]);
            }

            for (int i = n-2; i > -1; i--) {
                highestRight[i] = Math.max(building[i],highestRight[i+1]);
            }

            long water = 0 ;

            for(int i = 0 ; i < n ; i++){
                water = ( water + ( ( Math.min( highestRight[i],highestLeft[i] ) - building[i] )  %  1000000007 ) ) % 1000000007;
            }
            ans[t] = water;
        }
        for(int t = 0 ; t<tc;t++){
            System.out.println(ans[t]);
        }
    }
}