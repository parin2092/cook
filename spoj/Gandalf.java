/*input
1
100
*/
import java.util.Scanner;

class Gandalf {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		// int tc = 100;
		for(int t = 0 ; t < tc;t++){
			long n = in.nextInt();
			// long n = t+1;
			if (n == 1) {
				System.out.println(1);
			}else if(n == 2){
				System.out.println(2);
			}else{
				long a = 1;
				long b = 3;
				long c = 0;
				long mod = 1000000007;
				for(long i = 3; i <= n;i++){
					c = ((long)3 * b % mod) % mod - (a % mod);
					a = b ;
					b = c ;
				}
				System.out.println(c % mod);
			}
		}
	}
}