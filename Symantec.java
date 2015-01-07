import java.io.*;
import java.util.*;

class Node{
	String val;
	int idx;
	Node left;
	Node right;
	Node(String val,int idx){
		this.idx = idx;
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public void inOrder(){
		if (this.left != null) {
			this.left.inOrder();
		}
		System.out.println(this.val);
		if (this.right != null) {
			this.right.inOrder();
		}
	}
	public String toString(){
		return  this.val ;
	}
	public static int height(Node root){
		if (root == null) {
			return 0;
		}else{
			return 1 + Math.max(height(root.left) ,height(root.right));
		}
	}
	public static int diameter(Node root){
		if (root == null) {
			return 0;
		}

		int lh = 0, rh = 0;
		int ld = 0, rd = 0;
		lh = height(root.left);
		rh = height(root.right);
		ld = diameter(root.left);
		rd = diameter(root.right);

		return Math.max(1+lh+rh, Math.max(ld,rd));
    }
}

public class CandidateCode
{
    public static int maxMediators(String[] input1)
    {
    	int half = input1.length >> 1 ;
    	Node root = null;
    	Queue<Node> q = new LinkedList<Node>();
    	int i = 0;
		while(true){
			if (input1[i] == null) {
				i++;
				continue;
			}else{
				root = new Node(input1[i],i);
				q.add(root);
				break;
			}
		}
		Node prev = root;
		while(q.isEmpty() == false ){
			System.out.println(q);
			Node curr = q.remove();
			if (curr.idx >= half) {
				break;
			}
			String left = input1[2 * curr.idx];
			String right = input1[2 * curr.idx + 1];

			if (left != null) {
				curr.left = new Node(left,2*curr.idx);
				q.add(curr.left);
			}
			if (right != null) {
				curr.right = new Node(right,2*curr.idx+1);
				q.add(curr.right);
			}
			prev = curr;
			i++;
		}
		// root.inOrder();
		// System.out.println(Node.height(root));
    	return Node.diameter(root) - 2;
    }
    public static void main(String[] args) {
    	// String [] arr = {null,"D1","D2","D3","D4","D5","D6",null,"C1",null,"C2","C3","D7","D8",null,null,null,null,null,null,null,null,null,null,"C4",null,"C5","C6",null,null,null,null};
    	String [] arr = {null,"D1","C1","C2"};
	    System.out.println(	maxMediators(arr));
    }

}