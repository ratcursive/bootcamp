//Final version of MergeSort

public class MergeSort2{
	public static void main(String[] args){
		int[] arr ={1,2,5,8,9,13,4,52,3};
		int[] sortedArr = mergeSort(arr);
		printArr(sortedArr);
	}
	public static int[] mergeSort(int[] arr){
		int[] Arr = mergeSort(arr,0,arr.length);
		return Arr;
	}
	public static int[] mergeSort(int[] arr,int low,int high){
		int mid = (low + high)/2;
		if(high - low == 1){
			int[] array = new int[1];
			array[0] = arr[low];
			return array;
		}
		else{
			int[] left = mergeSort(arr,low, mid);
			int[] right = mergeSort(arr,mid,high);
			return merger(left,right);
		}
	}
	public static int[] merger(int[] leftSub, int[] rightSub){
		int[] mergedArr = new int[leftSub.length+rightSub.length];
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = 0; i < mergedArr.length; i++){
			if(leftSub[leftIndex] < rightSub[rightIndex]){
				mergedArr[i] = leftSub[leftIndex];
				if(leftSub.length-leftIndex > 1)
					leftIndex++;
				else
					leftSub[leftSub.length-1] = rightSub[rightSub.length-1] + 1;
			}
			else if(leftSub[leftIndex] > rightSub[rightIndex]){
				mergedArr[i] = rightSub[rightIndex];
				if(rightSub.length-rightIndex > 1)
					rightIndex++;
				else
					rightSub[rightSub.length-1] = leftSub[leftSub.length-1] + 1;
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
}