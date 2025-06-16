public class StackTest{
	public static void main(String[] args){
		Stack testStack = new Stack(40);
		Queue testQueue = new Queue();
		CircularQ Snake = new CircularQ(5);
		DoubleStack Squeue = new DoubleStack(5);
		Squeue.enqueue(3);
		Squeue.enqueue(1);
		Squeue.enqueue(4);
		Squeue.enqueue(5);
		Squeue.dequeue();
		Squeue.enqueue(6);
		Squeue.enqueue(7);
		Squeue.dequeue();
		Squeue.dequeue();
	}
}