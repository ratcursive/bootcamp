//First failed attempt at Merge Sort

public class MergeSort{
	public static void main(String[] args){
		int[] arr ={1,3,5,7,8,2,4,6};
		int[] sortedArr = divide(arr,arr);
		printArr(sortedArr);
	}
	public static void MergeSort(int[] arr){
		
	}
	public static int[] divide(int[] mainArr, int[] previousArr){
		printArr(previousArr);
		if(!isSorted(previousArr)){
			int[] leftSub = createLeftSub(previousArr);
			int[] rightSub = createRightSub(previousArr);
			
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
				return divide(mainArr,leftSub);
			}
			if(!isSorted(rightSub)){
				return divide(mainArr,rightSub);
			}
			else{
				previousArr = mergeBack(mainArr,leftSub,rightSub);
			}
			return divide(mainArr, previousArr);
		}
		return previousArr;
	}
	public static boolean isSorted(int[] arr){
		if(arr.length == 1)
			return true;
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i] > arr[i+1])
				return false;
		}
		return true;
	}
	public static int[] mergeBack(int[] mainArr, int[] leftSub, int[] rightSub){
		int[] mergedArr = new int[leftSub.length+rightSub.length];
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = 0; i < mergedArr.length; i++){
			if(leftSub[leftIndex] < rightSub[rightIndex]){
				mergedArr[i] = leftSub[leftIndex];
				if(leftSub.length > 1)
					leftIndex++;
				else
					leftSub[0] = rightSub[rightSub.length-1] + 1;
			}
			else if(leftSub[leftIndex] > rightSub[rightIndex]){
				mergedArr[i] = rightSub[rightIndex];
				if(rightSub.length > 1)
					rightIndex++;
				else
					rightSub[0] = leftSub[leftSub.length-1] + 1;
			}
		}
		return mergedArr;
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
	public static int[] createLeftSub(int[] arr){
		int[] leftSub = new int[arr.length/2];
		return leftSub;
	}
	public static int[] createRightSub(int[] arr){
		if(arr.length%2 == 1){
			int[] rightSub = new int[arr.length/2+1];
			return rightSub;
		}
		else{
			int[] rightSub = new int[arr.length/2];
			return rightSub;
		}
	}
}
