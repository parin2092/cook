import java.io.*;
public class CandidateCode
{
    public static String JudgementDay(int input1,int input2)
    {
    	long x = (long)input1;
    	long y = (long)input2;
    	long rp = 3;
    	long map = 1;
    	long pmp =  0;
        long crp , cmap , cpmp ;
        crp = cmap = cpmp = 0;

    	long mod = 1000000007L;
    	for(long i = 1 ; i <= ( x * y) ; i++ ){
            cpmp =( 5 * ((map) % mod) ) % mod;
            cmap = (rp + ((2 * pmp) % mod )) % mod;
            crp = (rp + ((3 * pmp) % mod) ) % mod;

            pmp = cpmp;
            map = cmap;
            rp = crp;
            String test = "" + crp +"#" +cmap +"#"+cpmp ;
            System.out.println(crp);
            System.out.println(cmap);
            System.out.println(cpmp);

            // System.out.println("day " + i + " " + test );
        }
        return "";
        // String ans = "" + crp +"#" +cmap +"#"+cpmp ;
        // return ans;
    }
    public static void main(String[] args) {
        System.out.println( JudgementDay(1000,1000));;
    }
}