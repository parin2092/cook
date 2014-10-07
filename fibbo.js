// WITH DP
function fibbo( n ) {
	if ( n <= 0 ) {
		return 0;
	}
	if ( n <= 2 ) {
		return 1;
	}
	if ( fibbo.cache[ n ] ) {
		return fibbo.cache[ n ];
	}
	fibbo.cache[ n ] = fibbo( n - 1 ) + fibbo( n - 2 );
	return fibbo.cache[ n ];
}

fibbo.cache = {};
console.log( fibbo( 40 ) );
console.assert( fibbo( 10 ) === 55 );


// WITHOUT DP
// function fibbo( n ) {
// 	if ( n <= 0 ) {
// 		return 0;
// 	}
// 	if ( n <= 2 ) {
// 		return 1;
// 	}

// 	return fibbo( n - 1 ) + fibbo( n - 2 );;
// }

// console.log( fibbo( 40 ) );
// console.assert( fibbo( 10 ) === 55 );
