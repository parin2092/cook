import java.util.*;
class NodeWithMin{
		int value;
		int min;
		NodeWithMin(int value,int min){
			this.value = value;
			this.min = min;
		}
		public int min(){
			return this.min;
		}
	}
class MinStack extends Stack<NodeWithMin>{
	public void push(int value){
		int min = Math.min(value,this.min());
		super.push(new NodeWithMin(value,min));
	}
	public int min(){
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		}else{
			return (this.peek()).min();
		}
	}
	public static void main(String []args){
		MinStack mStack = new MinStack();
		mStack.push(5);
		System.out.println(mStack.min());
		mStack.push(2);
		System.out.println(mStack.min());
		mStack.push(3);
		System.out.println(mStack.min());
		mStack.push(0);
		System.out.println(mStack.min());
		mStack.push(-1);
		System.out.println(mStack.min());
	}

}
