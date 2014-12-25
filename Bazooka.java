import java.io.*;
import java.util.*;

public class Bazooka {
    int x;
    int y;
    Bazooka(int x , int y){
        this.x = x;
        this.y = y;
    }

    public static boolean isSafe( int arr[ ][ ], int row, int col, boolean visited[ ][ ], int m, int n ) {
        return ( row >= 0 ) && ( row < m ) && ( col >= 0 ) && ( col < n ) && ( arr[ row ][ col ] != 0 && !visited[ row ][ col ] );
    }

    // public static void dfs( int arr[ ][ ], int row, int col, boolean visited[ ][ ], int m, int n,int[] troopc ) {
    //     int rowNbr[ ] = {
    //         -1, -1, -1, 0, 0, 1, 1, 1
    //     };
    //     int colNbr[ ] = {
    //         -1, 0, 1, -1, 1, -1, 0, 1
    //     };

    //     visited[ row ][ col ] = true;
    //     int max = 0;
    //     for ( int k = 0; k < 8; ++k ){
    //         if ( isSafe( arr, row + rowNbr[ k ], col + colNbr[ k ], visited, m, n ) ){
    //             troopc[0] += 1;
    //             dfs( arr, row + rowNbr[ k ], col + colNbr[ k ], visited, m, n ,troopc);
    //         }
    //     }
    // }
    public static int bfs(int arr[ ][ ], int x, int y ,boolean [][] visited,int m , int n){
        int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Bazooka> que = new LinkedList<Bazooka>();
        visited[x][y] = true;
        int count = 1;
        que.add(new Bazooka(x,y));
        while(!que.isEmpty()){
            Bazooka b = que.remove();
            for (int i = 0; i < 8 ;i++ ){
                int xx = b.x  + rowNbr[i];
                int yy = b.y + colNbr[i];

                if (isSafe(arr,xx,yy,visited,m,n)) {
                    visited[xx][yy] = true;
                    que.add(new Bazooka(xx,yy));
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] countGroups( int arr[ ][ ], int m, int n ) {
        boolean visited[ ][ ] = new boolean[ m ][ n ];
        int maxTroopc = -1;
        int count = 0;
        for ( int i = 0; i < m; ++i ){
            for ( int j = 0; j < n; ++j ){
                if ( arr[ i ][ j ] != 0 && !visited[ i ][ j ] )
                {
                    int troopc = bfs( arr, i, j, visited, m, n );
                    maxTroopc = Math.max(maxTroopc,troopc);
                    ++count;
                }
            }
        }
        int [] ans = {count,maxTroopc};
        return ans;
    }

    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );
        int tc = in.nextInt( );
        int ans[][] = new int[tc][2];
        for (int t = 0 ; t < tc ;t++ ) {
            int m = in.nextInt();
            int n = in.nextInt();
            int arr[][] = new int[m][n];

            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = in.nextInt();
                }
            }

            int tans[] = countGroups( arr,m,n );
            ans[t][0] = tans[0];
            ans[t][1] = tans[1];
        }
        for (int t = 0 ; t < tc ;t++ ) {
            System.out.println(ans[t][0] + " "+ ans[t][1]);
        }
    }

}
