m = [
	[ 0, 1, 1, 1 ],
	[ 1, 0, 0, 1 ],
	[ 1, 0, 0, 1 ],
	[ 1, 1, 1, 0 ]
];

var n = 4;
var visited = new Array( n );

function dfs( m, idx ) {
	console.log( "visiting ", idx );
	visited[ idx ] = true;
	for ( var i = 0, len = m[ i ].length; i < len; i++ ) {
		if ( visited[ i ] || i == idx ) {
			continue;
		} else {
			dfs( m, i );
		}
	};
}

dfs( m, 1 );
