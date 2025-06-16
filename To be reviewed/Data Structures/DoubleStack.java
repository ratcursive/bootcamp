public class DoubleStack{
    public Stack stack1;
    public Stack stack2;

    public DoubleStack(){
		this.stack1 = new Stack();
        this.stack2 = new Stack();
	}
    public DoubleStack(int x){
		this.stack1 = new Stack(x);
        this.stack2 = new Stack(x);
	}
    public void enqueue(int e){
        if(!stack1.isFull()){
			stack1.arr[stack1.pointer] = e;
			stack1.pointer++;
            stack1.printArr(stack1.arr);
		}
		else
			System.out.println("The stack is full");
    }
    public void dequeue(){
        for(int i = stack1.size()-1; i >= 0; i--){
            System.out.println(stack2.size());
            stack2.push(stack1.arr[i]);
            stack1.pop();
        }
        stack2.pop();
        for(int i = stack2.size()-1; i >= 0; i--){
            stack1.push(stack2.arr[i]);
            stack2.pop();
        }
        stack1.printArr(stack1.arr);

    }

}