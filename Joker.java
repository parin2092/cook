import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Joker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> cache = new LinkedHashMap<String,Integer>();
        int t = in.nextInt();
        int xyr[][] = new int[t][3];

        for(int i = 0; i < t ; i++){
            xyr[i][0]= in.nextInt();
            xyr[i][1]= in.nextInt();
            xyr[i][2]= in.nextInt();
        }
        for(int i = 0 ; i < t ; i++){
            int[] entry =  xyr[i];
            int temp;
            int mix = (entry[0] - entry[2]) > 0 ? (entry[0] - entry[2]) : 1;
            int miy = (entry[1] - entry[2]) > 0 ? (entry[1] - entry[2]) : 1;
            int max = (entry[0] + entry[2]) < 1001 ? (entry[0] + entry[2]) : 1000;
            int may = (entry[1] + entry[2]) < 1001 ? (entry[1] + entry[2]) : 1000;
            System.out.println(mix + " " + miy +" " + max +" " +may + " ");
            for (int j = mix; j <= max  ; j++) {
                for (int k = miy; k <= may ; k++) {
                    String key = "(" + j + "," +k +")";
                    if (cache.containsKey(key)) {
                        cache.put(key,cache.get(key)+1);
                    }else{
                        cache.put(key,1);
                    }
                }
            }
        }
        System.out.println(cache);

        int count = 0;
        for(String key : cache.keySet()){
            if (cache.get(key) >= 2) {
                System.out.println(key);
                count++;
            }
        }
        System.out.println(count);
    }
}
