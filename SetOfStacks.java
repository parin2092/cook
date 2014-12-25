import java.util.Stack;
import java.util.ArrayList;

class SetOfStacks {
	ArrayList<Stack> stacks;
	int lastStackId;
	int capacity;

	SetOfStacks(int capacity){
		this.stacks = new ArrayList<Stack>();
		this.lastStackId = -1;
		this.capacity = capacity;
	}

	public Stack getLastStack(){
		if (lastStackId == -1) {
			return null;
		}else{
			return stacks.get(lastStackId);
		}
	}

	public void push(int element) throws Exception{
		Stack lastStack = getLastStack();
		if (lastStack != null && lastStack.size() < capacity) {
			lastStack.push(element);
		}else{
			Stack newStack = new Stack();
			newStack.push(element);
			stacks.add(newStack);
			lastStackId++;
		}
	}
	public int pop(int sno,int )
	public String toString(){
		int len = stacks.size();
		String s = "";
		for(int i = 0;i<len;i++){
			s +=  (stacks.get(i)).toString() + " ";
		}
		return s;
	}
	public static void main(String[] args) throws Exception{
		try{
			SetOfStacks ss = new SetOfStacks(2);
			ss.push(1);
			ss.push(2);
			ss.push(3);
			ss.push(4);
			ss.push(5);
			ss.push(6);
			ss.push(7);
			System.out.println(ss);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}