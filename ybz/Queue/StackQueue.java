public class StackQueue
{
	private IntStack inner;
	private IntStack innerT;
	private int size;
	
	public StackQueue(int size)
	{
		this.size = size;
		this.inner = new IntStack(size);
		this.innerT = new IntStack(size);
	}
	
	public StackQueue() { this(10); }
	
	public int length() { return this.inner.length(); }
	
	public void toTemp()
	{
		while (!this.inner.isEmpty())
		{
			this.innerT.push(this.inner.pop());
		}
	}
	
	public void toInner()
	{
		while (!this.innerT.isEmpty())
		{
			this.inner.push(this.innerT.pop());
		}
	}
	
	public int first() 
	{
		if (isEmpty()) { throw new IllegalAccessError("Queue is Empty!"); }
		
		toTemp();
		int temp = this.innerT.top();
		toInner();
		return temp;
	}
	
	public boolean isEmpty() { return this.inner.isEmpty(); }
	
	public boolean isFull() { return this.inner.isFull(); }
	
	public void enqueue(int num)
	{
		if (isFull()) { throw new IllegalArgumentException("Queue is Full!"); }
		this.inner.push(num);
	}
	
	public int dequeue()
	{
		if (isEmpty()) { throw new IllegalAccessError("Queue is Empty!"); }
		
		toTemp();
		int temp = this.innerT.pop();
		toInner();
		return temp;
	}
	
	public String toString()
	{
		toTemp();
		int l = this.innerT.length();
		int[] temp = new int[l];
		
		for (int t = 0; t < l; t++)
		{
			temp[t] = innerT.pop();
		}
		for (int t = 0; t < temp.length; t++)
		{
			this.inner.push(temp[t]);
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("< ");
		for (int t = 0; t < temp.length-1; t++)
		{
			builder.append(temp[t] + " | ");
		}
		builder.append(temp[temp.length-1] + " >");
		
		
		return builder.toString();
	}
}