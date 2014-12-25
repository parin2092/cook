function lissum( array ) {
	var n = array.length;
	var dp = new Array( n )
	dp[ 0 ] = array[ 0 ];
	for ( var i = 1; i < n; i++ ) {
		dp[ i ] = array[ i ];
		for ( var j = 0; j < i; j++ ) {
			if ( array[ j ] <= array[ i ] && ( dp[ i ] < dp[ j ] + array[ i ] ) ) {
				dp[ i ] = dp[ j ] + array[ i ];
			};
		}
	}
	console.log( dp );
}

lissum( [ 100, 101, 10, 105, 102, 104 ] );
