import  java.util.*;

class Job implements Comparable<Job>{
	int id;
	int dead;
	int profit;

	Job(int id,int dead,int profit){
		this.id = id;
		this.dead  = dead;
		this.profit = profit;
	}

	public int compareTo(Job bjob){
		return (bjob.profit - this.profit);
	}
	public String toString(){
		return "" + id + " d==>" + dead +  " p==>"   + this.profit ;
	}
	public static String findResultSeq(ArrayList<Job> jobs){
		int n = jobs.size();
		int [] result = new int[n];
		boolean [] slots = new boolean[n];

		for (int i = 0 ; i < n ; i++ ) {
			Job j = jobs.get(i);
			for (int k = Math.min(j.dead,n) - 1 ; k >= 0 ; k--) {
				if (slots[k] == false) {
					result[k] = j.id;
					slots[k]  = true;
					break;
				}
			}
		}

		String seq = "";
		for (int i = 0 ; i < n  ; i++) {
			if (slots[i]) {
			 		seq += result[i];
			}
		}
		return seq;
	}
}
class SortObjs{
	public static void main(String[] args) {
		Job a = new Job(1,4,20);
		Job b = new Job(2,1,10);
		Job c = new Job(3,1,40);
		Job d = new Job(4,1,30);
		ArrayList<Job> all = new ArrayList<Job>();;
		all.add(a);
		all.add(b);
		all.add(c);
		all.add(d);
		// System.out.println(all);
		Collections.sort(all);
		System.out.println(all);
		System.out.println( Job.findResultSeq(all));
	}
}