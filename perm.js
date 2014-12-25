function get_all_permutations( array ) {
	return _perm( "", array, [] );
}


function _perm( permStr, remaining, all_perms ) {
	if ( permStr.length == 0 && remaining.length == 0 ) {
		return;
	} else if ( remaining.length == 0 ) {

		all_perms.push( permStr );

	} else {

		for ( var i = 0, len = remaining.length; i < len; i++ ) {
			var temp_rem = remaining.slice();
			var next_char = temp_rem.splice( i, 1 )[ 0 ];
			_perm( permStr + next_char, temp_rem, all_perms );
		};

	};
	return all_perms;
}

console.log( get_all_permutations( [ 1, 2, 3, 4 ] ) );
