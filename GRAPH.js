g = {
	1: [ 2, 3, 4 ],
	2: [ 1, 4 ],
	3: [ 4, 1 ],
	4: [ 1, 2, 3 ],
}

var n = 4;
var visited = new Array( n );

function dfs( graph, i ) {
	console.log( "Visiting ", i );
	visited[ i ] = true;
	var list = graph[ i ];

	for ( j = 0; j < list.length; j++ ) {
		if ( visited[ list[ j ] ] ) {
			continue;
		} else {
			dfs( graph, list[ j ] );
		}
	}
}

dfs( g, 3 );
