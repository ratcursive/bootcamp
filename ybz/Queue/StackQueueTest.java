public class StackQueueTest
{
	public static void main(String[] args)
	{
		StackQueue q  = new StackQueue(5);
		
		q.enqueue(5);
		q.enqueue(129);
		q.enqueue(6);
		q.enqueue(24);
		
		System.out.println(q);
		
		q.dequeue();
		q.dequeue();
		
		System.out.println(q);
		
		
	}
}