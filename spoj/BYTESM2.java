import java.util.Scanner;

class BYTESM2 {
	public static void main(String[] args) {
		// int arr[][] = {
		// 	{ 3, 1 , 7 , 4 , 2 } ,
		// 	{ 2, 1 , 3 , 1 , 1 } ,
		// 	{ 1, 2 , 2 , 1 , 8 } ,
		// 	{ 2, 2 , 1 , 5 , 3 } ,
		// 	{ 2, 1 , 4 , 4 , 4 } ,
		// 	{ 5, 2 , 7 , 5 , 1 } ,
		// };
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();

		for(int t = 0; t < tc ; t++){

			int m = in.nextInt();
			int n = in.nextInt();

			// int m = arr.length;
			// int n = arr[0].length;
			int arr[][] = new int[m][n];
			int dp[][] = new int[m][n];
			int max = 0;
			for(int i = 0 ; i < m;i++){

				for(int j = 0 ; j < n ; j++){

					arr[i][j] = in.nextInt();

					if (i != 0 && j != 0) {
						dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-1]);
					}

					if (i != 0 && j != n-1) {
						dp[i][j] = Math.max(dp[i][j] , dp[i-1][j+1]);
					}

					if (i != 0) {
						dp[i][j] = Math.max(dp[i][j] , dp[i-1][j]);
					}

					dp[i][j] += arr[i][j];
					max = Math.max(max,dp[i][j]);
				}

			}

			System.out.println(max);
		}
	}
}