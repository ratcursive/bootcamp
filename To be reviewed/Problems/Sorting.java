public class Sorting{
	public static void main (String[] args){
		String word = "deed";
		System.out.println(isPalindrome(word));
	}
	public static void selectionPass(int[] arr, int j){
		int max = 0;
		for(int i = 0; i < arr.length-(j); i++){
			if(max < arr[i])
				max = arr[i];
		}
		for(int i = 0; i < arr.length-(j+1); i++){
			if(arr[i] == max){
				arr[i] = arr[arr.length -(j+1)];
				i = -1;
			}
			
		}
		arr[arr.length - (j+1)] = max;
	}
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			selectionPass(arr,i);
			printArr(arr);
		}
	}
		public static void printArr(int[] arr){
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
	public static void countdown(int num)
	{
		if(num <= num && num >= 0)
		{
			System.out.println(num);
			countdown(num-1);
		}
	}
	public static int searchRange (int[] arr, int value){
		int high = arr.length-1;
		int low = 0;
		int mid = (high+low)/2;
		
		while(low != -1){
			if(arr[mid] < value){
				low = mid+1;
				mid = (high+low)/2;
			}
			else if(arr[mid] > value){
				high = mid-1;
				mid = (high+low)/2;
			}
			else if(arr[mid] == value){
				System.out.println("FOUND!");
				low = -1;
				return arr[mid];
				
			}
			else{
				System.out.println("NOT FOUND!");
				low = -1;
			}		
		}
		return 0;
	}
	public static int searchRecursive(int[] arr, int value,int low, int high){
		if(high >= low){
			int mid = (high+low)/2;
			if(arr[mid] < value){
				low = mid + 1;
				return searchRecursive(arr, value, low, high);
			}
			else if(arr[mid] > value){
				high = mid - 1;
				return searchRecursive(arr, value,low, high);
			}
			else if(arr[mid] == value){
				System.out.println("FOUND!");
				return arr[mid];
			}	
		}
		System.out.println("NOT FOUND!");
		return 0;
	}
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				j = -1;
			}
			printArr(arr);
		}
	}
	public static int findSingleNum (int[] arr){
		int count = 1;
		int num = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == num)
				count++;
			else if(arr[i] != num && count > 1){
				num = arr[i];
				count = 1;
			}
			else{
				System.out.println("The single number is at postion: " + i);
				return arr[i - 1];
			}
		}
		System.out.println("No single number found");
		return -1;
	}
	public static boolean isPalindrome(String word){
		return isPalindrome(word,0,word.length()-1);
	}
	public static boolean isPalindrome(String word,int start,int end){
		if(end > start){
			if (word.charAt(start) == word.charAt(end))
				return isPalindrome(word,start+1,end-1);
			else
				return false;
		}
		return true;
	}
	public static void divide(int[] mainArr, int[] previousArr){
		if(previousArr.length%2 == 1){
			int[] leftSub = new int[previousArr.length/2]
			int[] rightSub = new int[previousArr.length/2+1]
		}
		else{
			int[] leftSub = new int[previousArr.length/2]
			int[] rightSub = new int[previousArr.length/2]
		}
		for(int i = 0; i < previousArr.length; i++){
			if(i < leftSub.length)
				leftSub[i] = previousArr[i];
			else
				rightSub[i-leftSub.length] = previousArr[i];
		}
		
		//Check if left is sorted, if not, divide left
		//check if right is sorted,if not divide
		//if both are sorted, merge back
		if(!isSorted(leftSub)){
			divide(mainArr,leftSub);
		}
		if(!isSorted(rightSub)){
			divide(mainArr,rightSub);
		}
		else{
			previousArr = mergeBack(mainArr,leftSub,rightSub)
			//Method to backtrack and see the previous arrays
			//How do I do it????
		}
	}
	public static void isSorted(int[] arr){
		if(arr.length == 1)
			return true
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > arr[i+1])
				return false
		}
		return true;
	}
	public static int[] mergeBack(int[] mainArr, int[] leftSub, int[] rightSub){
		int[] mergedArr = new int[leftSub.length+rightSub.length]
		leftIndex = 0;
		rightIndex = 0;
		for(int i = 0; i < mergedArr.length; i++){
			if(leftSub[leftIndex] < rightSub[rightIndex]){
				mergedArr[i] = leftSub;
				leftIndex++;
			}
			else if(leftSub[leftIndex] > rightSub[rightIndex]){
				mergedArr[i] = rightSub;
				rightIndex++;
			}
		}
		return mergedArr
	}
}