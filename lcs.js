function longestCommonSub( m, n ) {
	var lcs = new Array( m + 1 );

	for ( var i = 0; i < ( m + 1 ); i++ ) {
		lcs[ i ] = new Array( n + 1 );
		lcs[ i ][ 0 ] = 0;
	}
	for ( var i = 0; i < ( n + 1 ); i++ ) {
		lcs[ 0 ][ i ] = 0;
	}
	console.log( lcs );


	for ( var i = 1; i <= m; i++ ) {
		for ( var j = 1; j <= n; j++ ) {
			if ( s1[ i - 1 ] === s2[ j - 1 ] ) {
				lcs[ i ][ j ] = 1 + lcs[ i - 1 ][ j - 1 ];
			} else {
				lcs[ i ][ j ] = Math.max( lcs[ i - 1 ][ j ], lcs[ i ][ j - 1 ] )
			}
		}
	}
	console.log( lcs );
}

s1 = "pari"
s2 = "npanri"
longestCommonSub( 4, 6 );
