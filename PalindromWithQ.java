class PalindromWithQ {
	public static int getNumberOfPalindroms(char []str){
		int n = str.length;
		int	mid = (n >> 1);
		n--;

		int palindroms = 1;
		boolean isPalindrom  = true;
		char [] a = str;
		for (int i = 0 ; i < mid ; i++ ) {
			if(a[i] != a[n-i] && a[i] == '?'){
				// a[i] is '?'
				a[i] = a[n-i];
			}else if(a[i] != a[n-i] && a[n-i] == '?'){
				// a[n-i] is '?'
				a[n-i] = a[i];
			}else if(a[i] == a[n-i] && a[i] != '?'){
				// both are non '?'
				continue;
			}else if(a[i] == a[n-i] && a[i] == '?'){
				// both are question mark
				palindroms *= 26;
			}else{
				// both not same 0 PALINDROMS can be generated
				isPalindrom = false;
				break;
			}
		}

		n++;
		if (!isPalindrom) {
			return 0;
		}else{
			if((mid * 2) == n){
				// even length palindrom
				return palindroms;
			}else{
				//  odd length palindrom
				if (a[mid] == '?') {
					palindroms *= 26;
				}
				return palindroms;
			}
		}
	}
	public static void main(String[] args) {
		String s1 = "a?a??a?a";
		String s2 = "a??a";
		String s3 = "a???a";
		String s4 = "ab??a";
		System.out.println(getNumberOfPalindroms(s1.toCharArray()));
		System.out.println(getNumberOfPalindroms(s2.toCharArray()));
		System.out.println(getNumberOfPalindroms(s3.toCharArray()));
		System.out.println(getNumberOfPalindroms(s4.toCharArray()));

	}
}