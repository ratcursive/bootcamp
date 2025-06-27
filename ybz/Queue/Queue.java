public class Queue
{
	private int[] inner;
	private int next;
	private int size;
	
	public Queue(int size)
	{
		this.inner = new int[size];
		this.size = size;
		this.next = 0;
	}
	
	public Queue() { this(10); }
	
	public int length() { return this.next; }
	
	public void enqueue(int num)
	{
		if (isFull()) { throw new IllegalArgumentException("Queue is Full!"); }
		
		this.inner[this.next] = num;
		
		this.next++;
	}
	
	public int dequeue()
	{
		if (isEmpty()) { throw new IllegalArgumentException("Queue is Empty!"); }
		
		int temp = this.inner[0];
		this.next--;
		for (int t = 0; t < this.next; t++)
		{
			this.inner[t] = this.inner[t+1];
		}
		return temp;
	}
	
	public int first()
	{
		if (isEmpty()) { throw new IllegalArgumentException("Queue is Empty!"); }
		
		return this.inner[0];
	}
	
	public boolean isFull() { return this.next == size; }
	
	public boolean isEmpty() { return this.next == 0; }
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("< ");
		for (int t = 0; t < this.next-1; t++)
		{
			builder.append(this.inner[t] + " | ");
		}
		if (!isEmpty())
		{
			builder.append(this.inner[next-1]);
		}
		builder.append(" >");
		return builder.toString();
	}
}