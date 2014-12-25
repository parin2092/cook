var shareValues = [ 1000, 100, 200, 400, 300, 50 ];
var shareValues1 = [ 100, 100, 60, 100, 100, 1000 ];
var shareValues2 = [ 900, 500, 100, 100, 1009, 90 ];
var shareValues3 = [ 900, 500, 100, 100, 1009, 1009 ];
var shareValues4 = [ 900, 500, 100, 100, 60, 70 ];
var shareValues5 = [ 900, 500, 100, 100, 60, 60 ];
var shareValues6 = [ 10, 20, 30, 50, 90, 1000 ];
var shareValues = [ 10, 20, 9, 21, 8, 22 ];

function findProfit( shareValues ) {
	var array_len = shareValues.length;
	var buy_value = 100000000000;
	var buy_day = 0;
	var sale_value = -1;
	var sale_day = 7;
	var profit = -1;

	for ( i = 0; i < array_len; i++ ) {
		// console.log( buy_day, buy_value, sale_day, sale_value )

		if ( shareValues[ i ] == buy_value ) {
			// to minimize no of days between purchase and sale
			buy_day = i;
		} else if ( shareValues[ i ] < buy_value && i < sale_day ) {
			buy_value = shareValues[ i ];
			buy_day = i;
		} else if (
			( shareValues[ i ] > sale_value ) ||
			( shareValues[ i ] - buy_value ) > profit
		) {
			sale_value = shareValues[ i ];
			sale_day = i;
		}

		profit = sale_value - buy_value;
	}

	if ( ( buy_day == sale_day ) || ( sale_day == 7 ) ) {
		console.log( "Not a good time to do business !!" );
	} else {
		console.log( "Buy share on day " + ( buy_day + 1 ) + " and sale it on day " + ( sale_day + 1 ) )
	}
}

findProfit( shareValues );
// findProfit( shareValues1 );
// findProfit( shareValues2 );
// findProfit( shareValues3 );
// findProfit( shareValues4 );
// findProfit( shareValues5 );
// findProfit( shareValues6 );
