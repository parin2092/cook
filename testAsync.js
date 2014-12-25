function t1() {
	setTimeout( function () {
		console.log( "t1 callback started." )
		var i = 10;
		while ( i < 100 ) {
			i++;
		}
		console.log( "t1 callback complete." )
	}, 10 );
}

function t2() {
	setTimeout( function () {
		console.log( "t2 callback started." )
		var i = 10;
		while ( i < 100 ) {
			i++;
		}
		console.log( "t2 callback complete." )
	}, 9 );
}

function t3() {
	setTimeout( function () {
		console.log( "t3 callback started." )
		var i = 10;
		while ( i < 100 ) {
			i++;
		}
		console.log( "t3 callback complete." )
	}, 10 );
}

function t4() {
	setTimeout( function () {
		console.log( "t4 callback started." )
		var i = 10;
		while ( i < 100 ) {
			i++;
		}
		console.log( "t4 callback complete." )
	}, 9 );
}

t1();
t4();
t3();
t2();
