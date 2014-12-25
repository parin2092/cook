function isPalindrom( a ) {
	var len = a.length;
	var n = len >> 1;

	if ( len == 0 ) {
		return false;
	};

	for ( var i = 0; i <= n; i++ ) {
		if ( a[ i ] != a[ len - 1 - i ] ) {
			return false;
		};
	};

	return true;
}

function isRotatedPalindrom( str ) {
	if ( 0 == str.length ) {
		return false;
	};
	if ( isPalindrom( str ) ) {
		return true;
	};

	n = str.length;
	for ( var i = 0; i <= ( n - 2 ); i++ ) {
		left = str.substr( 0, i + 1 );
		right = str.substr( i + 1 );
		if ( isPalindrom( right + left ) ) {
			return true;
		};
	};
	return false;
}

console.log( isRotatedPalindrom( "parin" ) );
