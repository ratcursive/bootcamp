public class Queue{
	
	private int pointer;
	private int size;
	private int[] arr;
	
	public Queue(){
		pointer = 0;
		size = 10;
		arr = new int[size];
	}
	public Queue(int x){
		pointer = 0;
		size = x;
		arr = new int[size];
	}
	public void enqueue(int e){
		if(isFull()){
			System.out.println("The queue is full");
		}
		else{
			arr[pointer] = e;
			pointer++;
			printArr(arr);
		}
	}
	public void dequeue(){
		if(isEmpty())
			System.out.println("The queue is empty");
		else{
			arr[0] = 0;
			for(int i = 1; i < pointer; i++)
				arr[i-1] = arr[i];
		}
	}
	public int first(){
		if(!isEmpty())
			return arr[pointer-1];
		else{
			System.out.println("The queue is empty");
			return -1;
		}
	}
	public int size(){
		return pointer;
		
	}
	public boolean isEmpty(){
		return pointer == 0;
	}
	public boolean isFull(){
		return pointer == size;
	}
	private void printArr(int[] arr)
	{
		//Prints the array inside curly braces and spaced by commas
		for(int i = 0; i < arr.length; i++)
		{
			if(i == 0)
				System.out.print("{" + arr[i]);
			
			else if(i < arr.length - 1)
				System.out.print("," + arr[i]);
			
			else
				System.out.print("," + arr[i] + "}");
		}
		System.out.println("");
	}
}