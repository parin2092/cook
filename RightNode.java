import java.util.*;

class RightNode{
	public static void main(String[] args) {
		BT  b = new BT(10);
		b.left = new BT(2);
		b.left.left = new BT(8);
		b.left.right = new BT(4);
		b.right = new BT(6);
		b.right.right = new BT(5);
		b.inOrder();
		BT node;
		System.out.println("hERE IT GOES");

		node = findRight(b,2);
		System.out.println(node);

		node = findRight(b,4);
		System.out.println(node);

		node = findRight(b,10);
		System.out.println(node);

		node = findRight(b,6);
		System.out.println(node);

		node = findRight(b,5);
		System.out.println(node);
	}

	public static BT findRight(BT root,int key){
		Queue<BT> q = new LinkedList<BT>();
		BT dummy = new BT(-9999999);
		q.add(root);
		q.add(dummy);

		while(!q.isEmpty()){
			BT node = q.remove();
			if (node.data == key) {
				break;
			}
			if (node == dummy) {
				if (q.isEmpty()) {
					break;
				}else{
					q.add(dummy);
				}
			}else{
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

		if(q.isEmpty()){
			return null;
		}else{
			BT node = q.remove();
			if (node == dummy) {
				return null;
			}else{
				return node;
			}
		}
	}

}

class BT {
	public int data;
	public BT left;
	public BT right;

	public BT (int value){
		this.data = value;
		this.left = null;
		this.right = null;
	}

	public void inOrder(){

		if (this.left != null) {
			this.left.inOrder();
		}

		System.out.println(this.data);

		if (this.right != null) {
			this.right.inOrder();
		}

	}
	public String toString(){
		return "" + this.data;
	}
}
