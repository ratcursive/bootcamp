public class Brackets
{
	public static void main(String[] args)
	{
		String brakkket = "{}[[]<{()[]}()>[<>]()]";
		
		System.out.println(brakkket);
		System.out.println(solver(brakkket));
		
		String alsoBrakkket = "}[]";
		
		System.out.println(alsoBrakkket);
		System.out.println(solver(alsoBrakkket));
		
	}
	
	private static boolean solver(String checkThis)
	{
		
		CharStack tracker = new CharStack((checkThis.length()/2)+1);
		
		for (int t = 0; t < checkThis.length(); t++)
		{
			char current = checkThis.charAt(t);
			boolean openBrac = (current == '(' || current == '[' || current == '{' || current == '<');
			boolean closeBrac = (current == ')' || current == ']' || current == '}' || current == '>');
			if (openBrac)
			{
				tracker.push(current);
			} else if (closeBrac) {
				if (current == ')')
				{
					if (tracker.pop() != '(') { return false; }
				} else if (tracker.isEmpty()){
					return false;
				} else if (!((int)current == ((int)tracker.pop())+2)) {
					return false;
				}
			}
		}
		
		return tracker.isEmpty();
	}
	
	private static void bracTest()
	{
		// opening round bracket : 40 / is the only bracket that increments by 1 instead of 2 when moving over to the closing bracket : see below
		System.out.println((int)'(');
		System.out.println((int)')');
		System.out.println((int)'{');
		System.out.println((int)'}');
		System.out.println((int)'[');
		System.out.println((int)']');
		System.out.println((int)'<');
		System.out.println((int)'>');
	}
}