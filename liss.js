var arr = [ 1, 101, 2, 3, 100, 4, 5 ];

function liss( a ) {
	var n = a.length;
	var dp = new Array( n );
	dp[ 0 ] = a[ 0 ];
	var max = 0;
	for ( var i = 1; i < n; i++ ) {
		dp[ i ] = dp[ i ] || 0;
		for ( var j = 0; j < i; j++ ) {
			if ( a[ i ] > a[ j ] && dp[ i ] < dp[ j ] + dp[ i ] ) {
				dp[ i ] = dp[ j ] + a[ i ];
			};
		}
		if ( max < dp[ i ] ) {
			max = dp[ i ];
		};
	}

	console.log( dp );
	return max;
}

console.log( liss( arr ) );
