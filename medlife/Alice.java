import java.util.Scanner;

public class Alice {
    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );
        int max = 1000000;

        int rs[] = new int[10];
        rs[0] = 0;
        rs[1] = 1;
        rs[2] = 2;
        rs[3] = 6;
        rs[4] = 6;
        rs[5] = 3;
        rs[6] = 9;
        rs[7] = 9;
        rs[8] = 9;
        rs[9] = 9;

        int tc = in.nextInt( );
        // int tc = 1;

        for (int t = 0 ; t < tc ; t++ ) {
            int a = in.nextInt();
            int b = in.nextInt();
            long sum = 0;
            for(int i = a; i <= b;i++){
                if (i >= 10) {
                    sum += 9;
                }else{
                    sum += rs[i];
                }
            }
            System.out.println(sum);
        }
    }
}