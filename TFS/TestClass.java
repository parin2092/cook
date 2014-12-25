import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

class TestClass {
	public static void main( String args[] ) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();
		int N = Integer.parseInt( line.split( " " )[ 0 ] );
		int M = Integer.parseInt( line.split( " " )[ 1 ] );

		line = br.readLine();
		String[] god = line.split( " " );
		LinkedHashMap < Integer, Integer > ageGodMap = new LinkedHashMap < Integer, Integer > ();
		int cage = -1, cgod = -1;
		int consistent = -1;

		for ( int i = 0; i < N; i++ ) {
			int age = Integer.parseInt( god[ i ] );
			if ( ageGodMap.containsKey( age ) ) {
				ageGodMap.put( age, ageGodMap.get( age ) + 1 );
			} else {
				ageGodMap.put( age, 1 );
			}
			int tempGod = ageGodMap.get( age );

			if ( tempGod > cgod ) {
				cgod = tempGod;
				cage = age;
				consistent = age;
			} else if ( tempGod == cgod && age > cage ) {
				cage = age;
			}
			System.out.println( cage + " " + ageGodMap.get( cage ) );
		}
	}
}
