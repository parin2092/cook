import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class TestClass {
    public static void main( String args[] ) throws Exception {
        HashMap < String, Integer > cache = new HashMap < String, Integer > ();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String line = br.readLine();
        int T = Integer.parseInt( line );
        for ( int i = 0; i < T; i++ ) {
            line = br.readLine();
            String inputs[] = line.split( " " );
            long ans = ways( 0, 0, 0, Integer.parseInt( inputs[ 0 ] ), Integer.parseInt( inputs[ 1 ] ), cache );
            System.out.println( ans % ( 1000000000 + 7 ) );
            System.out.println( cache );
        }

    }
    public static int ways( int dex, int man, int cr, int tr, int m, HashMap < String, Integer > cache ) {
        String key = dex + "" + man + "" + cr;
        System.out.println( key );
        int dw = 0, mw = 0;
        if ( cr == tr ) {
            // if ( dex > ( m * man ) ) {
            return 1;
            // } else {
            // return 0;
            // }
        }
        if ( ( dex + 1 ) >= ( m * man ) ) {
            String dkk = "" + ( dex + 1 ) + "" + man + "" + ( cr + 1 );
            if ( cache.containsKey( dkk ) ) {
                dw = cache.get( dkk );
                dw *= ways( 0, 0, tr - ( cr + 1 ), tr - )
            } else {
                dw = ways( dex + 1, man, cr + 1, tr, m, cache );
                cache.put( dkk, dw );
            }
        }
        if ( dex >= ( m * ( man + 1 ) ) ) {
            String mkk = "" + dex + "" + ( man + 1 ) + "" + ( cr + 1 );
            if ( cache.containsKey( mkk ) ) {
                mw = cache.get( mkk );
            } else {
                mw = ways( dex, man + 1, cr + 1, tr, m, cache );
                cache.put( mkk, mw );
            }
        }
        int ans = dw + mw;
        cache.put( key, ans );
        return ans;
    }
}
