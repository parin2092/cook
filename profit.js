var shareValues = [ 1000, 100, 200, 400, 300, 50 ];
// var shareValues = [ 100, 100, 100, 100, 100, 1000 ];

function findProfit( shareValues ) {
	var array_len = shareValues.length;
	var buy_day = 0;
	var sale_day = 0;
	var profit = 0;

	for ( i = 1; i < array_len; i++ ) {
		if ( shareValues[ i ] > shareValues[ sale_day ] ) {
			sale_day = i;
		} else if ( shareValues[ i ] < shareValues[ buy_day ] && sale_day > i ) {
			buy_day = i;
		}
	}

	if ( buy_day == sale_day ) {
		console.log( "Not a good time to do business !!" );
	} else {
		console.log( "Buy share on day " + ( buy_day + 1 ) + " and sale it on day " + ( sale_day + 1 ) )
	}
}

findProfit( shareValues );
