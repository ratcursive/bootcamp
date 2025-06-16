public class Stack{
	public int pointer;
	public int size;
	public int[] arr;
	
	public Stack(){
		pointer = 0;
		size = 10;
		arr = new int[size];
	}
	public Stack(int x){
		pointer = 0;
		size = x;
		arr = new int[size];
	}
	
	public void push(int e){
		if(!isFull()){
			arr[pointer] = e;
			pointer++;
			//printArr(arr);
		}
		else
			System.out.println("The stack is full");
	}
	public void pop(){
		if(!isEmpty()){
			pointer--;
			arr[pointer] = 0;
			//printArr(arr);
		}
		else
			System.out.println("The stack is empty");
	}
	public int top(){
		if(!isEmpty())
			return arr[pointer-1];
		else
			System.out.println("The stack is empty");
		return -1;
	}
	public boolean isEmpty(){
		return pointer == 0;
	}
	public boolean isFull(){
		return pointer == size;
	}
	public int size(){
		return pointer;
	}
	public static void printArr(int[] arr)
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