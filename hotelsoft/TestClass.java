import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
	public static int geti( String str ) {
		return Integer.parseInt( str );
	}
	public static int getScore( String[] sscore, int n ) {
		int[] a = new int[ n ];
		int ts = 0;
		for ( int i = 0; i < n; i++ ) {
			a[ i ] = geti( sscore[ i ] );
		}
		int i = 0;
		while ( i < n ) {
			if ( ( i + 3 ) == n && ( ( a[ i ] + a[ i + 1 ] ) == 10 ) ) {
				ts += a[ i ] + a[ i + 1 ] + a[ i + 2 ];
				break;
			}
			if ( ( i + 4 ) == n && a[ i ] == 10 ) {
				ts += a[ i + 1 ] + a[ i + 2 ] + a[ i + 3 ];
				break;
			}
			if ( ( i + 4 ) == n && a[ i + 1 ] == 10 ) {
				ts += a[ i ] + a[ i + 1 ] + a[ i + 2 ] + a[ i + 3 ];
				break;
			}
			if ( a[ i ] == 10 ) {
				ts += a[ i ] + ( 2 * a[ i + 1 ] );
				if ( i + 2 != n ) {
					ts += a[ i + 2 ];
				}
			} else if ( a[ i + 1 ] == 10 ) {
				ts += a[ i ] + a[ i + 1 ];
				if ( i + 2 != n ) {
					ts += a[ i + 2 ];
				}
				if ( i + 3 != n ) {
					ts += a[ i + 3 ];
				}
			} else if ( ( a[ i ] + a[ i + 1 ] ) == 10 ) {
				ts += a[ i ] + a[ i + 1 ];
				if ( i + 2 != n ) {
					ts += a[ i + 2 ];
				}
			} else {
				ts += a[ i ] + a[ i + 1 ];
			}
			i += 2;
		}
		return ts;
	}
	public static void main( String args[] ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();
		int testc = geti( line );
		for ( int i = 0; i < testc; i++ ) {
			line = br.readLine();
			String[] sscore = line.split( " " );
			int total = sscore.length;
			System.out.println( getScore( sscore, total ) );
		}
	}
}
