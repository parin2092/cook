print = console.log.bind( console );
var a = "parinkataria";
var b = "mayurkataria";
// var a = "APBCADCQER";
// var b = "RASBTAUCVE";

function lcs( x, y ) {
	var m = x.length;
	var n = y.length;
	var dp = new Array( m + 1 );
	for ( var i = 0; i <= m; i++ ) {
		dp[ i ] = new Array( n + 1 );
	}

	for ( var i = 0; i <= m; i++ ) {
		dp[ i ][ 0 ] = 0;
	}

	for ( var j = 0; j <= n; j++ ) {
		dp[ 0 ][ j ] = 0;
	}

	// print( dp )
	// process.exit();


	for ( var i = 1; i <= m; i++ ) {
		for ( var j = 1; j <= n; j++ ) {
			if ( x[ i - 1 ] === y[ j - 1 ] ) {
				dp[ i ][ j ] = 1 + dp[ i - 1 ][ j - 1 ];
			} else {
				dp[ i ][ j ] = Math.max( dp[ i - 1 ][ j ], dp[ i ][ j - 1 ] );
			}
		}
	}
	print( dp );
	print( findSub( dp, x, y, m, n ) );
	// print( findSubAllSub( dp, x, y, m, n ) );
	return dp[ m ][ n ];
}

function findSub( dp, x, y, i, j ) {
	var sub = "";
	if ( i === 0 || j === 0 ) {
		return "";
	} else if ( x[ i - 1 ] === y[ j - 1 ] ) {
		return findSub( dp, x, y, i - 1, j - 1 ) + x[ i - 1 ];
	} else {
		if ( dp[ i ][ j - 1 ] > dp[ i - 1 ][ j ] ) {
			return findSub( dp, x, y, i, j - 1 )
		} else {
			return findSub( dp, x, y, i - 1, j )
		}
	}
}

// function findSubAllSub( dp, x, y, i, j ) {
// 	var sub = "";
// 	if ( i === 0 || j === 0 ) {
// 		return [];
// 	} else if ( x[ i - 1 ] === y[ j - 1 ] ) {
// 		x[ i ] + findSubAllSub( dp, x, y, i - 1, j - 1 ) + x[ i - 1 ];
// 	} else {
// 		var r = [];
// 		if ( dp[ i ][ j - 1 ] >= dp[ i - 1 ][ j ] ) {
// 			r = findSubAllSub( dp, x, y, i, j - 1 )
// 		}
// 		if ( dp[ i - 1 ][ j ] >= dp[ i ][ j - 1 ] ) {
// 			r.push( findSubAllSub( dp, x, y, i - 1, j ) )
// 		}
// 		return r;
// 	}
// }

// LONGEST COMMON SUBSEQUENCE
lcs( a, b );
