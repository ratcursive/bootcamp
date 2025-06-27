public class IntStackTest
{
	public static void main(String[] args)
	{
		// new int stack
		IntStack stack = new IntStack(4);
		
		// add 3 numbers
		stack.push(1);
		stack.push(23);
		stack.push(7);
		
		// prints stack
		System.out.println(stack);
		
		// prints top
		System.out.println(stack.top());
		
		// pops top, stores in var
		int num = stack.pop();
		
		// prints stored var
		System.out.println(num);
	
		// prints stack
		System.out.println(stack);
		
		// add number
		stack.push(100);
		
		// prints stack
		System.out.println(stack);
		
		// prints length
		System.out.println(stack.length());
		
		// prints empty / full
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		
		// add number to make stack full
		stack.push(2);
		
		// prints full
		System.out.println(stack.isFull());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		/// prints empty
		System.out.println(stack.isEmpty());
	}
}