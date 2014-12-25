function lis( a ) {
	var n = arr.length;
	var dp = new Array( n );

	dp[ 0 ] = 1;
	var max = 0;
	for ( var i = 1; i < n; i++ ) {
		dp[ i ] = dp[ i ] || 1;
		for ( var j = 0; j < i; j++ ) {
			if ( a[ i ] > a[ j ] && dp[ i ] < dp[ j ] + 1 ) {
				dp[ i ] = dp[ j ] + 1;
			};
		}
		if ( dp[ i ] > max ) {
			max = dp[ i ];
		};
	}
	console.log( dp )
	return max;
}
var arr = [ 10, 22, 9, 33, 21, 50, 41, 60 ];
console.log( lis( arr ) );
