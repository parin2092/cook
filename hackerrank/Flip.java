import java.util.Scanner;

class Flip {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long mask = 4294967295L;

		int t = in.nextInt();
		for (int i = 0 ; i < t ; i++ ){
			System.out.println(in.nextLong() ^ mask);
		}
	}
}
