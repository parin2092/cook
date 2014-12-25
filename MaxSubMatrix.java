import java.util.*;
class MaxSubMatrix {
	public static void main(String[] args) {
		int mat[][] = {
			 	{0 , 1 , 1 , 0 , 1 },
				{1 , 1 , 0 , 1 , 0 },
				{0 , 1 , 1 , 1 , 0 },
				{1 , 1 , 1 , 1 , 0 },
			   	{1 , 1 , 1 , 1 , 1 },
			   	{0 , 0 , 0 , 0 , 0 },
		};

		int dp[][] = new int[mat.length][mat[0].length];

		copy(mat,dp);
		// printA(mat);
		// printA(dp);
		findMaxSubMat(mat,dp);
	}

	public static int findMaxSubMat(int [][]mat,int [][]dp){
		for (int i = 1,m = mat.length; i < m ; i++ ) {
			for (int j = 1,n = mat[i].length; j < n ; j++ ) {
				if (mat[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
				}else{
					dp[i][j] = 0;
				}
				System.out.println(mat[i][j] + " " + dp[i][j]);
			}
		}

		printA(mat);
		printA(dp);

		return 0;
	}
	public static void printA(int[][]mat){
		System.out.println();
		for (int i = 0,m = mat.length; i < m ; i++ ) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	public static void copy(int[][]current,int[][]old){
		for(int i=0; i<old.length; i++)
		  for(int j=0; j<old[i].length; j++)
		    old[i][j]=current[i][j];
	}
}
