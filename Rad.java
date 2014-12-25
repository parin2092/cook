import java.io.*;
import java.util.*;
import java.ArrayUtils;

class Point implements Comparable<Point> {
		int x;
		int y;
		Point(int x , int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point another){
			double d1 = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
			double d2 = Math.sqrt(Math.pow(another.x,2)+Math.pow(another.y,2));
			return (int )(d1 - d2);
		}
		public String toString(){
			return "" + this.x + " " + this.y;
		}
}
public class Rad {

    public static void main( String[ ] args ) {
        Scanner in = new Scanner( System.in );
        int tc = in.nextInt( );
        Point[] pos = new Point[tc];

        LinkedHashMap<Double,ArrayList<Point>> map = new LinkedHashMap<Double,ArrayList<Point>>();
        int ans[] = new int[tc];
        for (int t = 0 ; t < tc ;t++ ) {
        	int x = in.nextInt();
        	int y = in.nextInt();
        	Point p = new Point(x,y);
        	double angle = Math.atan2(y,x);
        	if (map.containsKey(angle)) {
        		ArrayList<Point> ps = map.get(angle);
        		ps.add(p);
        		map.put(angle,ps);
        	}else{
        		ArrayList<Point> ps = new ArrayList<Point>();
        		ps.add(p);
        		map.put(angle,ps);
        	}
        }
        public int[] toInt(Set<Integer> set) {
		  	int[] a = new int[set.size()];
		  	int i = 0;
		  	for (Integer val : set) a[i++] = val;
		  	return a;
		}
        Double[] angles = ArrayUtils.toPrimitive(map.keySet().toArray());
        Arrays.sort(angles);

        for (double angle : angles) {
        	ArrayList<Point> ps = map.get(angle);
        	if (ps.size() == 1) {
        		System.out.println(ps.get(0));
        	}else{
        		Collections.sort(ps);
        		for(int i = 0 ; i < ps.size() ; i++ ){
        			System.out.println(ps.get(i));
        		}
        	}
        }
    }

}