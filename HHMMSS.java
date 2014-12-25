class HHMMSS {
	public static void print(String time){
		String[] ts = time.split(" ");
		int[] primes = {2,3,5,7,9,13,17,19,23};
		int hh = Integer.parseInt(ts[0]);
		int mm = Integer.parseInt(ts[1]);
		int ss = Integer.parseInt(ts[2]);
		int bad = 0;
		for ( int i = 0 ,pn = primes.length ; i < pn;i++ ) {
			int p = primes[i];
			for ( int j =hh ; j < 24;) {
				boolean hchanged = false;
				for ( int k = mm ; k < 60; ) {
					boolean mchanged = false;
					for ( int l = ss ; l < 60;) {
						if( j % p == 0 && k % p == 0 && l % p == 0){
							bad += 1;
							l += p;
						}else{
							l++;
						}
					}
					if(mchanged){
						k+=p;
					}else{
						k++;
					}
				}
				if(hchanged){
					j+= p;
				}else{
					j++;
				}
			}
		}
		int tt = getTotalSeconds(hh,mm,ss);
		if(tt % bad == 0){
			tt = tt / bad;
			bad = 0;
		}
		System.out.println(bad+ ":" + tt);
	}
	public static void getTotalSeconds(int hh,int mm,int ss){
		return ((23-hh) * 60 * 60)+((59-mm)*60)+((60-ss));
	}
	public static void main(String args[]){
		print("23 59 58");
	}
}