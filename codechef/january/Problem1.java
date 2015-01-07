/*input
1
5 5
2 2 2
2 2 2
*/
import java.io.*;
import java.util.*;

class Problem1 {
	public static int findProfit(int n , int k , int [] mi,int []bi){
		int max_profit = Integer.MIN_VALUE;
		for(int i = 0 ; i< n; i++){
			int profit = k / mi[i];
			profit *= bi[i];
			if (profit > max_profit) {
				max_profit = profit;
			}
		}
		return max_profit;
	}
	public static void main( String[ ] args ) {
		Scanner in = new Scanner( System.in );
		int tc = in.nextInt( );
		int ans[] = new int[tc];
		for(int t = 0 ; t < tc ; t++){
			int n = in.nextInt();
			int k = in.nextInt();
			int mi[] = new int[n];
			int bi[] = new int[n];
			for(int i = 0; i < n;i++ ){
				mi[i] = in.nextInt();
			}
			for(int i = 0; i < n;i++ ){
				bi[i] = in.nextInt();
			}
			ans[t] = findProfit(n,k,mi,bi);
		}
		for(int t = 0 ; t < tc; t++){
			System.out.println(ans[t]);
		}
	}

}