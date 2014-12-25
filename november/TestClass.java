import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

class TestClass {
	public static void solveProblem( int n, int a, int b, int c, int[][] pq, LinkedHashMap < Integer, Integer > damage ) {

		for ( int i = 0; i < n; i++ ) {
			for ( Integer time: damage.keySet() ) {
				int p = pq[ i ][ 0 ], q = pq[ i ][ 1 ];
				if ( time >= p && time <= q ) {
					damage.put( time, damage.get( time ) + b );
				} else if ( time <= p ) {
					damage.put( time, damage.get( time ) + a );
				} else if ( time >= q ) {
					damage.put( time, damage.get( time ) + c );
				}
				System.out.println( p + " " + q + " " + damage );
			}
		}

		int maxDamage = -1;
		for ( Integer time: damage.keySet() ) {
			int damn = damage.get( time );
			if ( maxDamage < damn ) {
				maxDamage = damn;
			}
		}
		System.out.println( maxDamage );
	}
	public static int geti( String str ) {
		return Integer.parseInt( str );
	}
	public static void main( String args[] ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();
		int testc = geti( line );
		for ( int i = 0; i < testc; i++ ) {
			line = br.readLine();
			String[] nabc = line.split( " " );
			int n = geti( nabc[ 0 ] );
			int a = geti( nabc[ 1 ] );
			int b = geti( nabc[ 2 ] );
			int c = geti( nabc[ 3 ] );
			String[] pqs = new String[ n ];
			for ( int k = 0; k < n; k++ ) {
				pqs[ k ] = br.readLine();
			}
			int[][] pq = new int[ n ][ 2 ];
			LinkedHashMap < Integer, Integer > damage = new LinkedHashMap < Integer, Integer > ();

			for ( int j = 0; j < n; j++ ) {
				String[] s = pqs[ j ].split( " " );
				pq[ j ][ 0 ] = geti( s[ 0 ] );
				pq[ j ][ 1 ] = geti( s[ 1 ] );
				damage.put( pq[ j ][ 0 ], 0 );
				damage.put( pq[ j ][ 1 ], 0 );
			}
			solveProblem( n, a, b, c, pq, damage );
		}
	}
}
