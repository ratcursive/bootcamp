public class SubarrayAddition{
    public static int findHighestSumNested(int[] arr){
        int highestSum = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length-1; j >= i; j--){
                sum += arr[j];
                if(sum > highestSum)
                    highestSum = sum;
            }
            sum = 0;
        }
        return highestSum;
    }
    public static int findHighestSumRecursive(int arr[]){
        return findHighestSumRecursive(arr,0,arr.length,arr[0]);
    }
    private static int findHighestSumRecursive(int[] arr, int low, int high, int highestSum){
        int mid = (low + high)/2;
        if(high-low == 1){
            int sum = 0;
            for(int i = low; i < high; i++){
                sum += arr[i];
            }
            return sum;
        }
        else{
            int leftsum = findHighestSumRecursive(arr, low, mid, highestSum);
            int rightsum = findHighestSumRecursive(arr, mid, high, highestSum);
            return compareSums(arr, low, mid, high);
        }
    }
    public static int compareSums(int[] arr, int low, int mid, int high){
        int leftSum = 0;
        int rightSum = 0;
        for(int i = low; i < mid; i++){
            leftSum += arr[i];
        }
        for(int i = mid; i < high; i++){
            rightSum += arr[i];
        }
        int highestSum = leftSum;
        if(highestSum < rightSum)
            highestSum = rightSum;
        if(highestSum < leftSum + rightSum)
            highestSum = leftSum+rightSum;
        return highestSum;
    }
    public static int findHighestSumLinear(int[] arr){
        int currentStartingInd = 0;
        int highestStartingInd = 0;
        int endingInd = 0;
        int currentSum = 0;
        int highestSum = arr[0];
        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum > highestSum){
                highestSum = currentSum;
                endingInd = i;
                highestStartingInd = currentStartingInd;
            }
            if(currentSum < 0){
                currentSum = 0;
                highestStartingInd = currentStartingInd;
                currentStartingInd = i+1;
            }
        }
        printArr(arr, highestStartingInd, endingInd);
        return highestSum;
    }
    public static void printArr(int[] arr, int start, int end)
	{
		//Prints the array inside curly braces and spaced by commas
		for(int i = start; i <= end; i++)
		{
			if(i == start)
				System.out.print("{" + arr[i]);
			
			else if(i < end)
				System.out.print("," + arr[i]);
			
			else
				System.out.print("," + arr[i] + "}");
		}
		System.out.println("");
	}
    public static void main(String[] args){
        int[] arr = {1,2,3,-12385743,12385744};
        System.out.println(findHighestSumLinear(arr));
    }
    //{2,3,-8,7,-1,2,3};
}