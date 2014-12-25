function lis( array ) {
	var n = array.length;
	var dp = new Array( n );

	dp[ 0 ] = 1;
	for ( var j = 1; j < n; j++ ) {
		dp[ j ] = 1;
		for ( var k = 0; k < j; k++ ) {
			if ( array[ k ] <= array[ j ] && dp[ j ] < dp[ k ] + 1 ) {
				dp[ j ] = dp[ k ] + 1;
			};
		}
	}
	console.log( dp );
}
lis( [ 3, 2, 0, 4, 5, 0 ] );
lis( [ 100, 101, 10, 105, 102, 104 ] )
