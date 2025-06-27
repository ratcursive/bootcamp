public class IntStack{
	private int[] arr;
	private int next;
	private int size;
	
	public IntStack(int size)
	{
		this.size = size;
		this.arr = new int[size];
		next = 0;
	}
	
	public IntStack() { this(10); }
	
	public int length() { return next; }
	
	public int top()
	{
		if (isEmpty()) { throw new IllegalAccessError("Stack is Empty!"); }
		
		return this.arr[this.next-1];
	}
	
	public int pop()
	{
		if (isEmpty()) { throw new IllegalAccessError("Stack is Empty!"); }
		
		int temp = this.arr[next-1];
		next--;
		this.arr[this.next] = 0;
		return temp;
	}
	
	public void push(int num)
	{
		if (isFull()) { throw new IllegalAccessError("Stack is Full!"); }
		
		this.arr[next] = num;
		this.next++;
	}
	
	public boolean isEmpty() { return this.next == 0; }
	
	public boolean isFull() { return this.next == this.size; }
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		if (!isEmpty()) { builder.append("> " + this.arr[next-1]+" <\n"); }
		
		for (int t = next-2; t >= 0; t--)
		{
			builder.append("< " + this.arr[t]+" >\n");
		}
		
		return builder.toString();
	}
}