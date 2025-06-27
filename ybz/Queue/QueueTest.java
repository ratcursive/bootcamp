public class QueueTest
{
	public static void main(String[] args)
	{
		Queue q = new Queue(4);
		
		System.out.println(q);
		
		q.enqueue(10);
		q.enqueue(8);
		q.enqueue(11);
		q.enqueue(25);
		
		System.out.println(q);
		
		int n1 = q.dequeue();
		
		System.out.println(n1);
		System.out.println(q);
		q.enqueue(100);
		
		System.out.println(q.first());
		
		System.out.println(q.isFull());
		System.out.println(q.isEmpty());
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		System.out.println(q.isFull());
		System.out.println(q.isEmpty());
	}
}