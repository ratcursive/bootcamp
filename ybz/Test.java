public class Test
{
	public static void main(String[] args)
	{
		// int[] unsorted = {10,5,7,1,6,8,3,4};
		
		// int[] sorted = Algorithms.mergeSort(unsorted);
		// print(unsorted);
		// print(sorted);
		
		// int[] array = {1,3,4,5,6,7,8,10};
		
		// System.out.print(Algorithms.binarySearch(array,11));
		
		
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] arr2 = {8,-2,3,-70,8,7,12,-50,3,-2};
		int[] arr3 = {12,-7,34,-25,8,-3,15,-40,20,5};
		
		int[] subArr = Algorithms.findSubArray(arr3);
		print(subArr);
		System.out.println(sum(subArr));
	}
	
	public static void print(int[] arr)
	{
		for (int i : arr)
		{
			System.out.print(i + " / ");
		}
		System.out.println();
	}
	
	public static int sum(int[] arr)
	{
		int total = 0;
		for (int i : arr)
		{
			total+=i;
		}
		return total;
	}
}