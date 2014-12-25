function evaluate( input1 ) {
	initFallbacks();
	var eqs = input1.split( ";" );
	var n = eqs.length;
	var meq = eqs[ 0 ].split( /[\+\-\*\/]/ )
	for ( var i = 1; i < n; i++ ) {
		var eq = eqs[ i ].split( "=" );
		var variable = eq[ 0 ];
		var value = eq[ 1 ];
		meq = meq.map( function( item ) {

			var prefix = item.length > 1 ? "*" : "";
			item = item.replace( variable, prefix + value )

			return item;
		} )
	};

	var operators = getOperators( input1 );
	var i = -1;
	var finalEq = meq.reduce( function( a, b ) {
		i++;
		return ( a + operators[ i ] + b );
	} )

	return eval( finalEq );

	function getOperators( input1 ) {
		var delimeters = [];
		var delims = [ '+', '-', '*', '/' ];
		var len = input1.length;
		for ( var i = 0; i < len; i++ ) {
			if ( delims.indexOf( input1[ i ] ) !== -1 ) {
				delimeters.push( input1[ i ] );
			};
		};
		return delimeters;
	};


}

function initFallbacks() {
	// fallbacks
	// Production steps of ECMA-262, Edition 5, 15.4.4.19
	// Reference: http://es5.github.io/#x15.4.4.19
	if ( !Array.prototype.map ) {

		Array.prototype.map = function( callback, thisArg ) {

			var T, A, k;

			if ( this == null ) {
				throw new TypeError( ' this is null or not defined' );
			}

			// 1. Let O be the result of calling ToObject passing the |this|
			//    value as the argument.
			var O = Object( this );

			// 2. Let lenValue be the result of calling the Get internal
			//    method of O with the argument "length".
			// 3. Let len be ToUint32(lenValue).
			var len = O.length >>> 0;

			// 4. If IsCallable(callback) is false, throw a TypeError exception.
			// See: http://es5.github.com/#x9.11
			if ( typeof callback !== 'function' ) {
				throw new TypeError( callback + ' is not a function' );
			}

			// 5. If thisArg was supplied, let T be thisArg; else let T be undefined.
			if ( arguments.length > 1 ) {
				T = thisArg;
			}

			// 6. Let A be a new array created as if by the expression new Array(len)
			//    where Array is the standard built-in constructor with that name and
			//    len is the value of len.
			A = new Array( len );

			// 7. Let k be 0
			k = 0;

			// 8. Repeat, while k < len
			while ( k < len ) {

				var kValue, mappedValue;

				// a. Let Pk be ToString(k).
				//   This is implicit for LHS operands of the in operator
				// b. Let kPresent be the result of calling the HasProperty internal
				//    method of O with argument Pk.
				//   This step can be combined with c
				// c. If kPresent is true, then
				if ( k in O ) {

					// i. Let kValue be the result of calling the Get internal
					//    method of O with argument Pk.
					kValue = O[ k ];

					// ii. Let mappedValue be the result of calling the Call internal
					//     method of callback with T as the this value and argument
					//     list containing kValue, k, and O.
					mappedValue = callback.call( T, kValue, k, O );

					// iii. Call the DefineOwnProperty internal method of A with arguments
					// Pk, Property Descriptor
					// { Value: mappedValue,
					//   Writable: true,
					//   Enumerable: true,
					//   Configurable: true },
					// and false.

					// In browsers that support Object.defineProperty, use the following:
					// Object.defineProperty(A, k, {
					//   value: mappedValue,
					//   writable: true,
					//   enumerable: true,
					//   configurable: true
					// });

					// For best browser support, use the following:
					A[ k ] = mappedValue;
				}
				// d. Increase k by 1.
				k++;
			}

			// 9. return A
			return A;
		};
	}
	if ( !Array.prototype.reduce ) {
		Array.prototype.reduce = function( callback /*, initialValue*/ ) {
			'use strict';
			if ( this == null ) {
				throw new TypeError( 'Array.prototype.reduce called on null or undefined' );
			}
			if ( typeof callback !== 'function' ) {
				throw new TypeError( callback + ' is not a function' );
			}
			var t = Object( this ),
				len = t.length >>> 0,
				k = 0,
				value;
			if ( arguments.length == 2 ) {
				value = arguments[ 1 ];
			} else {
				while ( k < len && !k in t ) {
					k++;
				}
				if ( k >= len ) {
					throw new TypeError( 'Reduce of empty array with no initial value' );
				}
				value = t[ k++ ];
			}
			for ( ; k < len; k++ ) {
				if ( k in t ) {
					value = callback( value, t[ k ], k, t );
				}
			}
			return value;
		};
	}
}
str = "9x+2y+z+18;x=7;y=2;z=9";
console.log( evaluate( str ) );
str = "9a+8b+m-5n+z;a=2;b=0;m=-8;n=24;z=9"
console.log( evaluate( str ) );
