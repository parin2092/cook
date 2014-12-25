import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main( String args[] ) throws Exception {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String line = br.readLine();
        int T = Integer.parseInt( line );
        for ( int i = 0; i < T; i++ ) {
            line = br.readLine();
            String inputs[] = line.split( " " );
            long ans = ways( 0, 0, 0, Integer.parseInt( inputs[ 0 ] ), Integer.parseInt( inputs[ 1 ] ) );
            System.out.println( ans % ( 1000000000 + 7 ) );
        }

    }
    public static int ways( int dex, int man, int cr, int tr, int m ) {
        int dw = 0, mw = 0;
        if ( cr == tr ) {
            return 1;
        }

        if ( ( dex + 1 ) >= ( m * man ) ) {
            if ( ( cr + 1 ) == tr ) {
                dw = 1;
            } else {
                dw = ways( dex + 1, man, cr + 1, tr, m );
            }
        }
        if ( dex >= ( m * ( man + 1 ) ) ) {
            if ( ( cr + 1 ) == tr ) {
                mw = 1;
            } else {
                mw = ways( dex, man + 1, cr + 1, tr, m );
            }
        }
        return ( dw + mw );
    }
}
