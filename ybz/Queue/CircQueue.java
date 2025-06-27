public class CircQueue
{
	private int[] inner;
	private int lPos;
	private int rPos;
	private int size;
	
	public void printInfo()
	{
		for (int i : this.inner)
		{
			System.out.print(i + " | ");
		}
		System.out.println();
		System.out.println("left position: " + this.lPos);
		System.out.println("right position: " + this.rPos);
		System.out.println("is empty: " + isEmpty());
		System.out.println("is full: " + isFull());
	}
	
	public CircQueue(int size)
	{
		if (size <=2) { throw new IllegalArgumentException("Queue Must be of Size 2 or Higher!"); }
		
		this.size = size;
		this.inner = new int[size];
		this.lPos = 0;
		this.rPos = 0;
	}
	
	public CircQueue() { this(10); }
	
	public int length()
	{
		if (this.lPos > this.rPos)
		{
			return this.rPos+this.size-this.lPos;
		} else {
			return this.rPos-this.lPos;
		}
	}
	
	public boolean isFull() 
	{ 
		if (this.rPos < this.lPos)
		{
			return length() == this.size-1; 
		} else {
			return length() == this.size; 
		}
		
	}
	
	public boolean isEmpty() { return this.lPos == this.rPos; }
	
	public int first()
	{
		if (isEmpty()) { throw new IllegalAccessError("Queue is Empty!"); }
		return this.inner[this.lPos];
	}
	
	public void enqueue(int num)
	{
		if (isFull()) { throw new IllegalArgumentException("Queue is Full!"); }
		
		if (this.rPos == this.size)
		{
			this.inner[0] = num;
		} else if (this.rPos < this.lPos){
			this.inner[this.rPos+1] = num;
		} else {
			this.inner[this.rPos] = num;
		}
		
		
		this.rPos++;
		if (this.rPos == this.size+1)
		{
			this.rPos = 0;
		}
	}
	
	public int dequeue()
	{
		if (isEmpty()) { throw new IllegalAccessError("Queue is Empty!"); }
		
		int temp = this.inner[this.lPos];
		
		this.lPos++;
		if (this.lPos == this.size)
		{
			this.lPos = 0;
			this.rPos++;
		}
		
		return temp;
	}
	
	public boolean checkBounds() { return !isFull(); }
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("< ");
		
		if (this.rPos < this.lPos)
		{
			for (int t = this.lPos; t < this.size; t++)
			{
				builder.append(this.inner[t] + " | ");
			}
			for (int t = 0; t < this.rPos; t++)
			{
				builder.append(this.inner[t] + " | ");
			}
		} else {
			for (int t = this.lPos; t < this.rPos-1; t++)
			{
				builder.append(this.inner[t] + " | ");
			}
		}
		if (!isEmpty())
		{
			if (this.rPos < this.lPos)
			{
				builder.append(this.inner[this.rPos]);
			} else {
				builder.append(this.inner[this.rPos-1]);
			}
			
		}
		builder.append(" >");
		
		return builder.toString();
	}
}