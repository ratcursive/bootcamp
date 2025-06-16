public class InversionCounter{
	static int inversionCount;
	public static void main(String[] args){
		int[] arr ={4,3,2,1};
		int[] sortedArr = mergeSort(arr);
		printArr(sortedArr);
		System.out.println(inversionCount);
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
        int mergedIndex = 0;
		while(leftIndex < leftSub.length && rightIndex < rightSub.length){
			if(leftSub[leftIndex] < rightSub[rightIndex]){
                mergedArr[mergedIndex] = leftSub[leftIndex];
                leftIndex++;
            }
            else if(leftSub[leftIndex] > rightSub[rightIndex]){
                mergedArr[mergedIndex] = rightSub[rightIndex];
                rightIndex++;
				inversionCount++;
            }
            mergedIndex++;

		}
        
        while(leftIndex < leftSub.length){
            mergedArr[mergedIndex] = leftSub[leftIndex];
            leftIndex++;
			mergedIndex++;
        }
        while(rightIndex < rightSub.length){
            mergedArr[mergedIndex] = rightSub[rightIndex];
            rightIndex++;
			mergedIndex++;
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