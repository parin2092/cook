class Walks {
	public static int count(int[][] graph,int u, int v, int k){
		if (k == 0 && u == v) return 1;
		if (k == 1) return graph[u][v];
		if (k <= 0) return 0;
		int walks = 0;
		for(int i = 0 ; i < graph.length; i++){
			// for node I adjacent to U
			if (graph[u][i] == 1) {
				walks += count(graph,i,v,k-1);
			}
		}
		return walks;
	}
	public static int countDp(int [][] graph,int u, int v,int k){
		int V = graph.length;
		int[][][] dp = new int[V][V][k+1];

		for(int e = 0 ; e <= k;e++){
			for(int i = 0 ; i < V;i++){
				for(int j = 0 ; j < V ; j++){
					dp[i][j][e] = 0;
					if (e == 0 && u == v) {
						dp[i][j][e] = 1;
						continue;
					}
					if (e == 1 && graph[i][j] == 1) {
						dp[i][j][e] = 1;
					}
					if (e > 1) {
						for(int a = 0 ; a < V ; a++){
							if (graph[i][a] == 1) {
								dp[i][j][e] += dp[a][j][e-1];
							}
						}
					}
				}
			}
		}

		return dp[u][v][k];
	}
	public static void main(String[] args) {
		final int V = 4;
		int [][] graph = {
							{0, 1, 1, 1},
	                        {0, 0, 0, 1},
	                        {0, 0, 0, 1},
	                        {0, 0, 0, 0}
                      };
    	int u = 0, v = 3, k = 2;

    	System.out.println(count(graph,u,v,k));
    	System.out.println(countDp(graph,u,v,k));
	}
}
