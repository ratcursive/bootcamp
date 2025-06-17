public class CircularQ{
	private int head;
	private int tail;
	private int size;
	private int[] arr;
	
	public CircularQ(){
		head = 0;
		tail = 0;
		size = 0;
		arr = new int[10];
	}
	public CircularQ(int x){
		head = 0;
		tail = 0;
		size = 0;
		arr = new int[x];
	}
	
	public void enqueue(int e){
		if(isFull())
			System.out.println("The queue is full");
		else{
			if(tail == arr.length)
				tail = 0;
			arr[tail] = e;
			tail++;
			size++;
			System.out.println(size);
			printArr(arr, size, head);
		}
	}
	public void dequeue(){
		if(isEmpty())
			System.out.println("The queue is empty");
		else{
			if(head == arr.length)
				head = 0;
			arr[head] = 0;
			head++;
			size--;
			printArr(arr, size, head);
		}
	}
	public boolean isEmpty(){return size == 0;}
	public boolean isFull(){return size == arr.length;}
	private void printArr(int[] arr, int size, int head)
	{
		//Prints the array inside curly braces and spaced by commas
		int index = head;
		for(int i = 0; i < size; i++)
		{
			if(head >= arr.length -1)
				head = 0;
			
			if(i == 0)
				System.out.print("{" + arr[index]);
			else if(i < size - 1)
				System.out.print("," + arr[index]);
			else
				System.out.print("," + arr[index] + "}");
			
			index++;
		}
		if(index - head == 1){
			System.out.print("}");
		}
		System.out.println("");
	}
	
}