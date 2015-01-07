import java.io.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {
	public static int geti(String i){
		return Integer.parseInt(i);
	}

    public static void main( String[ ] args ) {

        Scanner in = new Scanner( System.in );
        int n = in.nextInt( );
        int q = in.nextInt( );

        int[] arr = new int[n];
        int[] ans= new int[q];

        String[] qs = new String[q];
        int[][] qsij = new int[q][2];

        for(int i = 0 ; i < n ; i++){
        	arr[i] = in.nextInt();
        }

        for(int iq = 0 ; iq < q; iq++){
        	qs[iq] = in.next();
            int i = in.nextInt();
            int j = in.nextInt();
            qsij[iq][0] = i;
            qsij[iq][1] = j;
            if (qs[iq].equals("S")) {
                int sum = 0;
                for(int idx = i ; idx <= j ; idx++){
                    sum += arr[idx];
                }
                ans[iq] = sum;
            }else if(qs[iq].equals("U")){
                arr[i] += j;
            }else if(qs[iq].equals("V")){
                arr[i] -= j;
            }
        }
        for(int iq = 0 ; iq < q; iq++){
            if (ans[iq] == 0) {
                continue;
            }
        	System.out.println(ans[iq]);
        }

    }

}