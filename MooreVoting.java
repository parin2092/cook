class MooreVoting {
	public static void findMajorityElement(int arr[]){
		int len = arr.length;
		int midx = 0;
		int c = 1;
		for (int i = 1 ; i < n+1 ; i++) {
			if (a[i] == a[midx]) {
				c++;
			}else{
				c--;
			}
			if ( c == 0 ) {
				midx = i;
			}
		}
	}
}