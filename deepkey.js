function keys( obj ) {
	if ( [ null, undefined, "" ].indexOf( obj ) !== -1 ) {
		return [];
	};
	var a_k = Object.keys( obj );

	if ( a_k.length ) {

		for ( var k in obj ) {
			if ( typeof obj[ k ] === "object" ) {
				var e_k = keys( obj[ k ] );
				if ( e_k.length ) {
					for ( var i = e_k.length - 1; i >= 0; i-- ) {
						e_k[ i ] = k + e_k;
					};
					a_k = a_k.concat( e_k );
				};
			};
		}
		return a_k;
	} else {
		return [];
	}
}
var obj = {
	a: 1,
	b: {
		c: 1
	},
	c: {
		d: {
			e: 1
		},
		f: 1
	},
	d: {
		e: {
			f: {
				g: 1,
				h: 2
			}
		}
	},
	e: 2,
	f: {
		g: []
	}
};
console.log( keys( obj ) );
