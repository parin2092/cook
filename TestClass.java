import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
// import java.util.Arrays;

class TestClass {
	public static boolean primeh( int n ) {
		if ( n < 2 )
			return false;
		if ( n == 2 )
			return true;
		if ( n == 3 )
			return true;
		if ( n % 2 == 0 )
			return false;
		if ( n % 3 == 0 )
			return false;

		int i = 5;
		int w = 2;
		while ( i * i <= n ) {
			if ( n % i == 0 ) {
				return false;
			}
			i += w;
			w = 6 - w;
		}

		return true;
	}

	public static void fury( LinkedHashMap<Integer,Integer> primes, int min, int max ) {
		min--;
		max--;
		int ans = 0;
		for ( Integer index: primes.keySet() ) {
			if ( index <= max && index >= min ) {
				ans++;
			}
		}
		System.out.println( ans );
	}

	public static void change( LinkedHashMap<Integer,Integer> primes, int oldIndex, int newValue ) {
		oldIndex--;
		if ( primeh( newValue ) ) {
			primes.put( oldIndex, newValue );
		} else {
			primes.remove( oldIndex );
		}
	}
	public static void processTestCase( int n, int[] positions, int q, String[] qs ) {
		LinkedHashMap<Integer,Integer> primes = new LinkedHashMap<Integer,Integer> ();
		for ( int i = 0; i < n; i++ ) {
			int pos = positions[ i ];
			if ( primeh( pos ) ) {
				primes.put( i, pos );
			}
		}
		for ( int i = 0; i < q; i++ ) {
			String[] ss = qs[ i ].split( " " );
			int b = Integer.parseInt( ss[ 1 ] ), c = Integer.parseInt( ss[ 2 ] );
			char a = ss[ 0 ].charAt( 0 );
			switch ( a ) {
			case 'A':
				fury( primes, b, c );
				break;
			case 'C':
				change( primes, b, c );
				positions[ b-1 ] = c;
				break;
			}
		}
	}
	public static void main( String args[] ) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();
		int t = Integer.parseInt( line );
		for ( int i = 0; i < t; i++ ) {
			// each test case
			line = br.readLine();
			int n = Integer.parseInt( line );

			line = br.readLine();
			String[] vals = line.split( " " );
			int arr[] = new int[ n ];
			for ( int k = 0; k < n; k++ ) {
				arr[ k ] = Integer.parseInt( vals[ k ] );
			}
			// System.out.println(Arrays.toString(arr));
			line = br.readLine();
			int q = Integer.parseInt( line );
			String[] qs = new String[ q ];
			for ( int j = 0; j < q; j++ ) {
				line = br.readLine();
				qs[ j ] = line;
			}
			processTestCase( n, arr, q, qs );
		}

	}

}
