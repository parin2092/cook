public class EditDistance {
	public static int getEditDistance( String x, String y ) {
		int n1 = x.length();
		int n2 = y.length();
		char xc[] = x.toCharArray();
		char yc[] = y.toCharArray();

		if ( n1 == 0 || n2 == 0 ) {
			return ( n1 > n2 ? n1 : n2 );
		}

		int[][] mat = new int[ n1 + 1 ][ n2 + 1 ];
		for ( int i = 1; i <= n1; i++ ) {
			for ( int j = 1; j <= n2; j++ ) {
				if ( xc[ i - 1 ] == yc[ j - 1 ] ) {
					mat[ i ][ j ] = mat[ i - 1 ][ j - 1 ];
				} else {
					mat[ i ][ j ] = Math.min( Math.min( mat[ i - 1 ][ j ] + 1, mat[ i ][ j - 1 ] + 1 ), mat[ i - 1 ][ j - 1 ] + 1 );
				}
			}
		}
		return mat[ n1 ][ n2 ];
	}

	public static void main( String[] args ) {
		String x = "COMPUeERd";
		String y = "COMMUTER";

		System.out.println( getEditDistance( x, y ) );
	}
}
