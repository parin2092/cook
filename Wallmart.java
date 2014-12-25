import java.io.*;
import java.util.Collections;
import java.util.Arrays;
public class Wallmart {
	public static int jobMachine( String[] input1 ) {
		int n = input1.length;
		int[] lis = new int[ n ];
		Duration duration[] = new Duration[ n ];
		populateDuration( duration, input1 );
		Arrays.sort( duration );
		System.out.println( Arrays.toString( duration ) );
		for ( int i = 0; i < n; i++ ) {
			lis[ i ] = 1;
			for ( int j = 0; j < i; j++ ) {
				if ( ( lis[ i ] < ( lis[ j ] + 1 ) ) && duration[ j ].end <= duration[ i ].start ) {
					lis[ i ] = lis[ j ] + 1;
				}
			}
			System.out.println( Arrays.toString( lis ) );
		}
		return lis[ n - 1 ] * 500;
	}
	public static class Duration implements Comparable < Duration > {
		public int start;
		public int end;
		Duration( int s, int e ) {
			this.start = s;
			this.end = e;
		}
		public int compareTo( Duration another ) {
			if ( this.start == another.start ) {
				return this.end - another.end;
			}
			return this.start - another.start;
		}
		public String toString() {
			return "" + this.start + "=>" + this.end;
		}

	}

	public static int getIntVal( String str ) {
		return Integer.parseInt( str );
	}
	public static int get24time( String time ) {
		String ampm = time.split( "\\d+" )[ 1 ];
		String atime = time.split( "\\D" )[ 0 ];
		if ( ampm.equals( "AM" ) ) {
			return getIntVal( atime );
		} else {
			int t = getIntVal( atime );
			return ( t < 12 ? t + 12 : t );
		}
	}
	public static void populateDuration( Duration[] durObjs, String[] dur ) {
		int n = dur.length;
		for ( int i = 0; i < n; i++ ) {
			String[] se = dur[ i ].split( "#" );
			int s = get24time( se[ 0 ] );
			int e = get24time( se[ 1 ] );
			durObjs[ i ] = new Duration( s, e );
		}
	}
	public static void main( String[] args ) {
		String[] durations = {
			"6AM#8AM", "11AM#1PM", "7AM#3PM", "7AM#10AM", "10AM#12PM", "2PM#4PM", "1PM#4PM", "8AM#9AM"
		};
		System.out.println( jobMachine( durations ) );
	}

}
