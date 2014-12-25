/*
 * Complete the function below.
 */
function getDNAAlignment( dna1, dna2 ) {

	var n1 = dna1.length;
	var n2 = dna2.length;

	var dp = new Array( n1 + 1 );
	for ( i = 0; i <= n1; i++ ) {
		dp[ i ] = new Array( n2 + 1 );
		dp[ i ][ 0 ] = 0;
	}
	for ( j = 0; j <= n2; j++ ) {
		dp[ 0 ][ j ] = 0;
	}

	var mat, del, ins, a, b, gp;

	var whichOne = ( n1 == n2 ) ? 0 : ( ( n1 > n2 ) ? 1 : 2 );

	for ( var i = 1; i <= n1; i++ ) {
		for ( var j = 1; j <= n2; j++ ) {

			switch ( whichOne ) {
				case 1:
					a = dna1[ i - 1 ];
					b = '-';
					break;
				case 2:
					a = '-';
					b = dna2[ j - 1 ];
					break;
				default:
					a = dna1[ i - 1 ];
					b = dna2[ j - 1 ];
			}
			gp = getScore( a, b );

			mat = dp[ i - 1 ][ j - 1 ] + getScore( dna1[ i - 1 ], dna2[ j - 1 ] );

			del = dp[ i - 1 ][ j ] + gp;

			ins = dp[ i ][ j - 1 ] + gp;

			dp[ i ][ j ] = Math.max( mat, del, ins );
		}
	}

	return dp[ n1 ][ n2 ];
}

var scores = {};
scores[ 'AA' ] = 5;
scores[ 'AC' ] = -1;
scores[ 'AG' ] = -2;
scores[ 'AT' ] = -1;
scores[ 'A-' ] = -3;

scores[ 'CA' ] = -1;
scores[ 'CC' ] = 5;
scores[ 'CG' ] = -3;
scores[ 'CT' ] = -2;
scores[ 'C-' ] = -4;


scores[ 'GA' ] = -2;
scores[ 'GC' ] = -3;
scores[ 'GG' ] = 5;
scores[ 'GT' ] = -2;
scores[ 'G-' ] = -2;


scores[ 'TA' ] = -1;
scores[ 'TC' ] = -2;
scores[ 'TG' ] = -2;
scores[ 'TT' ] = 5;
scores[ 'T-' ] = -1;

scores[ '-A' ] = -3;
scores[ '-C' ] = -4;
scores[ '-G' ] = -2;
scores[ '-T' ] = -1;
scores[ '--' ] = 1000;

function getScore( a, b ) {
	return scores[ a + b ];
}

var dna1 = 'AGTGATG';
var dna2 = 'GTTAG';
console.log( getDNAAlignment( dna1, dna2 ) )


dna1 = 'AGCTATT';
dna2 = 'AGCTTTAAA';

console.log( getDNAAlignment( dna1, dna2 ) )
