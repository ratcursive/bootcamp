public class Unions{
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,6,7};
        int[] arr2 = {1,3,4,5,10,11};
        findDiferrences(arr1, arr2);
        printArr(findUnion(arr1, arr2));

    }
    public static int[] findUnion(int[] arr1, int[] arr2){
        int[] unionArr = new int[arr1.length+arr2.length-findIntersectCount(arr1, arr2)];
        int unionArrIndex = 0;
        for(int i = 0; i < arr1.length; i++){
            unionArr[unionArrIndex] = arr1[i];
            unionArrIndex++;
        }
        int[] arr2Differences = findDiferrences(arr2, arr1);
        for(int i = 0; i < arr2Differences.length; i++){
            unionArr[unionArrIndex] = arr2Differences[i];
            unionArrIndex++;
        }
        return unionArr;
    }
    public static int[] findIntersects(int[] arr1, int[] arr2){
        int[] intersectArr = new int[findIntersectCount(arr1, arr2)];
        int arr2Index = 0;
        int intersectArrIndex = 0;
        for(int i = 0; i < arr1.length; i++){
            while(arr2Index < arr2.length && arr2[arr2Index] != arr1[i]){
                arr2Index++;
            }
            if(arr2Index < arr2.length){
                intersectArr[intersectArrIndex] = arr2[arr2Index];
                intersectArrIndex++;
            }
            arr2Index = 0;
        }
        return intersectArr;
    }
    public static int findIntersectCount(int[] arr1, int[] arr2){
        int arrSize = 0;
        int arr2Index = 0;
        for(int i = 0; i < arr1.length; i++){
            while(arr2Index < arr2.length && arr2[arr2Index] != arr1[i]){
                arr2Index++;
            }
            if(arr2Index < arr2.length){
                arrSize++;
            }
            arr2Index = 0;
        }
        return arrSize;
    }
    public static int[] findDiferrences(int[] arr1, int[] arr2){
        int arr2Index = 0;
        int differenceArrSize = 0;
        for(int i = 0; i < arr1.length; i++){
            while(arr2Index < arr2.length && arr2[arr2Index] != arr1[i]){
                arr2Index++;
            }
            if(arr2Index == arr2.length){
                differenceArrSize++;
            }
            arr2Index = 0;
        }
        int[] differenceArr = new int[differenceArrSize];
        int differenceArrIndex = 0;
        for(int i = 0; i < arr1.length; i++){
            while(arr2Index < arr2.length && arr2[arr2Index] != arr1[i]){
                arr2Index++;
            }
            if(arr2Index == arr2.length){
                differenceArr[differenceArrIndex] = arr1[i]; 
                differenceArrIndex++;
            }
            arr2Index = 0;
        }
        return differenceArr;
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