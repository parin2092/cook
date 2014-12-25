print = console.log.bind( console );

var d = {
	'a': [ '0', '1' ],
	'b': [ '3', '4', '5' ],
	'c': [ '2' ],
	'g': [ '6', '7', '8' ],
	'h': [ '9' ]
}

function findAll( str ) {
	return decoding( "", str, d );
}
var op = []

function decoding( str, rem ) {
	// print( arguments );
	if ( rem == "" ) {
		op.push( str );
	} else {
		var first = rem[ 0 ];
		rem = rem.substr( 1 );
		decoding( str + first, rem );
		var da = d[ first ];
		var n = da.length;
		// print( "= ", first, "== ", str, "=== ", rem, "==== ", n );
		for ( var i = 0; i < n; i++ ) {
			var c = d[ first ][ i ];
			decoding( str + c, rem );
			// print( c );
		};
	}
}

// test
findAll( "abcgh" );
print( op.length )
