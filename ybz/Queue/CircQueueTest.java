public class CircQueueTest
{
	public static void main(String[] args)
	{
		CircQueue q = new CircQueue(5);
		
		System.out.println(q.isEmpty());
		
		q.enqueue(10);
		q.enqueue(14);
		q.enqueue(2);
		q.enqueue(37);
		
		System.out.println(q);
		System.out.println(q.length());
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q.isEmpty());
		
		System.out.println();
		
		q.enqueue(1);
		
		System.out.println();
		q.printInfo();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		System.out.println(q);
		
		q.dequeue();
		
		q.enqueue(100);
		System.out.println(q);
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		
		q.enqueue(4);
		q.enqueue(89);
		q.enqueue(67);
		q.dequeue();
		System.out.println(q);
	}
}