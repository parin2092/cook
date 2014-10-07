var args = [].slice.call( process.argv );

args.forEach( function( val, index, array ) {
	console.log( index + ': ' + val );
	array[ index ] = "parin";
} );

console.log( "All args ", args )
