// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.Arrays;

class Valid {

	public static int f( String seq ) {
		int bal = 0;
		int mbal = 0;
		int n = seq.length();
		for ( int i = 0; i < n; i++ ) {
			if ( seq.charAt( i ) == '(' ) {
				bal++;
			} else if ( seq.charAt( i ) == ')' ) {
				bal--;
			}
			mbal = Math.max( mbal, bal );
		}
		return mbal;
	}

	public static void main( String args[] ) throws Exception {

		java.io.BufferedReader br = new java.io.BufferedReader( new java.io.InputStreamReader( System.in ) );
		String line = br.readLine();
		int t = Integer.parseInt( line );
		String outputs[] = new String[ t ];
		for ( int i = 0; i < t; i++ ) {
			// each test case
			line = br.readLine();

			int mbal = f( line );
			String rseq = "";
			for ( int j = 0; j < mbal; j++ ) {
				rseq = rseq + '(';
			}
			for ( int j = 0; j < mbal; j++ ) {
				rseq = rseq + ')';
			}
			outputs[ i ] = rseq;
		}
		for ( int i = 0; i < t; i++ ) {
			System.out.println( outputs[ i ] );
		}
		System.out.println( rseq );

	}

}
