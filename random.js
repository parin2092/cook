print = console.log.bind( console );

function rand5() {
	return Math.floor( Math.random() * 5 );;
}
print( rand5( 4 ) );


function sanityCheck( rFunc ) {
	var dict = {};
	for ( var i = 0; i < 100000; i++ ) {
		var r = rFunc();
		dict[ r ] = dict[ r ] || 0;
		dict[ r ] += 1;
	}
	return dict;
}
print( sanityCheck( rand5 ) );

function rand7() {
	result = 21;
	while ( result >= 21 )
		result = rand5() * 5 + rand5();
	return result % 7;
}

function myrand7() {
	result = 8;
	while ( result >= 8 )
		result = rand5() + rand5();
	return result % 7;
}

print( sanityCheck( myrand7 ) );
print( sanityCheck( rand7 ) );
