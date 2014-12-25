import java.util.Arrays;
class Stack3 {
	int[] stack;
	int[] p;
	int stackSize ;

	public Stack3(int stackSize,int noOfstacks){
		this.stackSize = stackSize;
		this.stack = new int[stackSize * 3];
		this.p = new int[noOfstacks];

	}

	public void push(int sno,int elem){
		sno--;
		int index = sno * this.stackSize + this.p[sno];
		if (index > (this.stackSize * sno) ) {
			return;
		}
		index++;
		this.p[sno] += 1;
		this.stack[index] = elem;
	}

	public int pop(int sno){
		sno--;
		int index = sno * this.stackSize + this.p[sno];
		int elem = stack[index];
		this.stack[index] = -1;
		this.p[sno] = p[sno] - 1;
		return elem;
	}

	public String toString(){
		return Arrays.toString(this.stack);
	}

	public static void main(String args[]){
		Stack3 s = new Stack3(10,3);
		System.out.println(s);
		s.push(1,1);
		s.push(2,1);
		s.push(3,1);
		System.out.println(s);
	}
}