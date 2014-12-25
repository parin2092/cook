print = console.log.bind( console );

function interleave( s1, s2, s, i, j, k ) {
	if ( s1[ i ] == undefined && s2[ j ] == undefined ) {
		print( s );
		return;
	}

	if ( s1[ i ] != undefined ) {
		temp[ k ] = s1[ i ];
		interleave( s1, s2, temp, i + 1, j, k + 1 );
	}

	var temp = s.slice();

	if ( s2[ j ] != undefined ) {
		temp[ k ] = s2[ j ];
		interleave( s1, s2, temp, i, j + 1, k + 1 );
	}
}

interleave( "AB", "CD", "    ", 0, 0, 0 );
