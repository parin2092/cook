import java.util.*;

class PK {

	public static void main(String[] args) {
	 	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10);
	 	minHeap.add(15);
	 	minHeap.add(5);
	 	minHeap.add(10);
	 	minHeap.add(20);
	 	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,Collections.reverseOrder());
	 	maxHeap.add(15);
	 	maxHeap.add(5);
	 	maxHeap.add(10);
	 	maxHeap.add(20);
	 	System.out.println( minHeap );
	 	System.out.println( maxHeap );
	}
}