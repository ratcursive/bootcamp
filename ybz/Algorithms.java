public class Algorithms
{
	private static int[] intoNewArray(int[] array)
	{
		int[] arr = new int[array.length];
		
		for (int t = 0; t < arr.length; t++)
			arr[t] = array[t];
		
		return arr;
	}
	
	// not sure if this is the optimal solution...??
	public static int[] findSubArray(int[] arr)
	{
		// biggest sum of subarray
		
		int largestSum = arr[0];
		int currentSum = 0;
		
		int sumLeft = 0;
		int sumRight = 0;
		
		int curLeft = 0;
		int curRight = 0;
		
		for (int t = 0; t < arr.length; t++)
		{
			curRight = t;
			
			if (currentSum + arr[t] > arr[t])
			{
				currentSum+=arr[t];
			} else {
				currentSum=arr[t];
				curLeft=t;
			}
			if (currentSum > largestSum)
			{
				largestSum = currentSum;
				sumLeft = curLeft;
				sumRight = curRight;
			}
		}
		
		int[] subArr = new int[sumRight-sumLeft+1];
		int i = 0;
		for (int t = sumLeft; t <= sumRight; t++)
		{
			subArr[i] = arr[t];
			i++;
		}
		return subArr;
	}
	
	public static boolean checkPalindrome(String checkThis)
	{
		return palindrome(checkThis, 0, checkThis.length()-1);
	}
	
	private static boolean palindrome(String checkThis, int low, int high)
	{
		boolean isOdd = checkThis.length()%2 == 1;
		if ((isOdd && high-low == 0 ) || (!isOdd) && high-low == 1)
		{
			return true;
		} else if (checkThis.charAt(low) == checkThis.charAt(high)) {
			return true && palindrome(checkThis, low+1, high-1);
		} else {
			return false;
		}
	}
	
	public static int[] mergeSort(int[] array)
	{
		int[] arr = intoNewArray(array);
		return mSort(arr, 0, arr.length-1);
	}
	
	private static int[] mSort(int[] arr, int low, int high)
	{
		int[] left;
		int[] right;
		
		if (low != high)
		{
			left = mSort(arr, low, (low+high)/2);
			right = mSort(arr, (low+high)/2+1, high);	
		} else {
			int[] num = {arr[low]};
			return num;
		}
		int[] sorted = new int[left.length+right.length];
		
		int lIndex = 0;
		int rIndex = 0;
		for (int t = 0; t < sorted.length; t++)
		{
			if (lIndex == left.length)
			{
				sorted[t] = right[rIndex];
				rIndex++;
			} else if (rIndex == right.length) {
				sorted[t] = left[lIndex];
				lIndex++;
			} else if (left[lIndex] > right[rIndex]) {
				sorted[t] = right[rIndex];
				rIndex++;
			} else {
				sorted[t] = left[lIndex];
				lIndex++;
			}
		}
		return sorted;
	}
	
	public static int binarySearch(int[] arr, int findThis)
	{
		return bSearch(arr, findThis, 0, arr.length-1);
	}
	
	private static int bSearch(int[] arr,int findThis, int low, int high)
	{
		int middle = (high+low)/2;
		if (high-low == 1) {
			return -1;
		} else if (findThis == arr[middle]) {
			return middle;
		} else if (findThis > arr[middle]) {
			return bSearch(arr, findThis, middle, high);
		} else {
			return bSearch(arr, findThis, low, middle);
		}
	}
	
	public static int[] insertionSort(int[] array)
	{
		int[] arr = intoNewArray(array);
		
		for (int t = 1; t < arr.length; t++)
		{
			int k = t-1;
			
			while (k > 0 && arr[t] < arr[k])
				k--;
			
			if (arr[t] > arr[k])
				k++;
			
			int swap = arr[t];
			
			for (int i = t; i > k; i--)
				arr[i] = arr[i-1];
			
			arr[k] = swap;
		}
		return arr;
	}
	
	public static int[] bubbleSort(int[] array)
	{
		int[] arr = intoNewArray(array);
		
		for (int t = 0; t < arr.length; t++)
		{
			for (int i = 0; i < arr.length-t-1; i++)
			{
				if (arr[i] > arr[i+1])
				{
					int swap = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = swap;
				}
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] array)
	{
		int[] arr = intoNewArray(array);
		
		for (int t = 0; t < arr.length-1; t++)
		{
			int k = t;
			for (int i = k; i < arr.length; i++)
			{
				if (arr[i] < arr[k])
					k = i;
			}
			int swap = arr[t];
			arr[t] = arr[k];
			arr[k] = swap;
		}
		return arr;
	}
}