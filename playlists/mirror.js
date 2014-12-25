print = console.log.bind( console );
root = {};
root.data = 4;
root.right = {
	'data': 6,
	'left': {
		'data': 5,
		'left': null,
		'right': null
	},
	'right': {
		'data': 7,
		'left': null,
		'right': null
	}
}
root.left = {
	'data': 2,
	'left': {
		'data': 1,
		'left': null,
		'right': null
	},
	'right': {
		'data': 3,
		'left': null,
		'right': null
	}
}

print( root )

function mirror( root ) {
	if ( root ) {
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror( root.left );
		mirror( root.right )
	}
	return;
}
mirror( root );
print( root );
