import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class BSTSwapped {
	public int value;
	BSTSwapped left;
	BSTSwapped right;

	BSTSwapped( int value ) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void add( int newNodeValue ) {
		if ( newNodeValue < this.value ) {
			if ( this.left == null ) {
				this.left = new BSTSwapped( newNodeValue );
			} else {
				this.left.add( newNodeValue );
			}
		} else {
			if ( this.right == null ) {
				this.right = new BSTSwapped( newNodeValue );
			} else {
				this.right.add( newNodeValue );
			}
		}
	}
	public String toString() {
		Queue q = new LinkedList<Integer>();
		this.inOrder(q);
		return Arrays.toString(q.toArray());
	}

	public void inOrder( Queue q ) {
		if ( this.left != null ) {
			this.left.inOrder( q );
		}

		q.add( this );

		if ( this.right != null ) {
			this.right.inOrder( q );
		}
	}
	public static void main( String[] args ) {
		BSTSwapped bst = new BSTSwapped( 10 );
		bst.add( 6 );
		bst.add( 4 );
		bst.add( 7 );
		bst.add( 13 );
		bst.add( 11 );
		bst.add( 15 );

		bst.left.right.value += bst.right.value;
		bst.right.value = bst.left.right.value - bst.right.value;
		bst.left.right.value -= bst.right.value;
		// System.out.println(bst);
		bst.rectify();
	}
	public void rectify(){
		Queue<BSTSwapped> q = new LinkedList<BSTSwapped>();
		this.inOrder( q );
		// System.out.println( q );
		Object [] a = q.toArray();
		BSTSwapped [] swappedNodes = {null,null};

		int len = a.length;
		for(int i=1;i<len;i++){
			a[i] = (BSTSwapped) a[i];
			a[i+1] = (BSTSwapped) a[i+1];
			a[i-1] = (BSTSwapped) a[i-1];

			if (
			    (a[i].value < a[i+1].value && a[i].value < a[i-1].value ) ||
			    (a[i].value > a[i+1].value && a[i].value > a[i-1].value )
			    ) {
				if (swappedNodes[0] != null){
					swappedNodes[1] = a[i];
				}else{
					swappedNodes[0] = a[i];
				}
			}
		}
		System.out.println(swappedNodes[0].value);
		System.out.println(swappedNodes[1].value);
	}
}
