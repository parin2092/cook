class ReplaceSpace {
	public static void replaceSpaces( char arr[], int length ) {
		int spaceCount = 0;

		for ( int i = 0; i < length; i++ )
			spaceCount += ( arr[ i ] == ' ' ? 1 : 0 );

		int newLength = length + spaceCount * 2;
		arr[ newLength ] = '\0';
		for ( int i = length - 1; i >= 0; i-- ) {
			if ( arr[ i ] == ' ' ) {
				arr[ newLength - 1 ] = '0';
				arr[ newLength - 2 ] = '2';
				arr[ newLength - 3 ] = '%';
				newLength -= 3;
			} else {
				arr[ newLength - 1 ] = arr[ i ];
				newLength -= 1;
			}
		}
	}

	public static void main( String[] args ) {
		char arr[] = ( "name is please.Bitch please." )
			.toCharArray();
		replaceSpaces( arr, 29 );
		System.out.println( new String( arr ) );
	}
}
