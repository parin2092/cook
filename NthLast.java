class NthLast {
	class Node {
		int data;
		Node next;
		Node( int data ) {
			this.data = data;
		}
	}
	static int currentN;
	public Node findNthLast( Node node, int n ) {
		currentN = n;
		if ( node == null ) {
			return nullww;
		}
		findNthLast( node.next );
		currentN--;
		if ( currentN == 0 ) {
			return node;
		}
	}

	public static void main( String[] args ) {
		Node head = new Node( 11 );
		head.next = new Node( 22 );
		head.next.next = new Node( 33 );
		head.next.next.next = new Node( 44 );
		head.next.next.next.next = new Node( 55 );
		findNthLast( head, 2 );
	}
}
