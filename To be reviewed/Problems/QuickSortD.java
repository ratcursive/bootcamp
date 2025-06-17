public class QuickSortD{
   public static void main(String[] args) {
       int[] arr ={10,3,15,4,6,2};
        quickSort(arr, arr.length-1,0);
        printArr(arr);
   }
    // Method to code the first instance of quickSort
    public static void quickSort(int[] arr, int high,int low){
        System.out.println("NEW INSTANCE!");
        printArr(arr);
        System.out.println("High: " + high);
        System.out.println("Low: " + low);
        if(high-low < 1){

        }
        else{
            int pivot = (high+low)/2;
            System.out.println("Pivot Value: " + arr[pivot]);
            //Move pivot to the end
            pivot = moveElementToIndex(arr, pivot, high);
            printArr(arr);
            int pointerL = low;
            int pointerR = pivot - 1;
            System.out.println("L Value: " + arr[pointerL]);
            System.out.println("R Value: " + arr[pointerR]);
            System.out.println("Pivot Value: " + arr[pivot]);
            while(pointerL < pointerR){
                while(arr[pointerL] <= arr[pivot] && pointerL < arr.length-1){
                    pointerL++;
                    System.out.println("L: " + arr[pointerL]);
                }
                while(arr[pointerR] > arr[pivot] && pointerR > 0){
                    pointerR--;
                    System.out.println("R: " + arr[pointerR]);
                }
                if(pointerL < pointerR){
                    swapElements(arr, pointerL, pointerR);
                    System.out.println("SWAP");
                    printArr(arr);
                }
            }
            printArr(arr);
            System.out.println("L: " + pointerL);
            System.out.println("R: " + pointerR);
            if(pointerL >= pointerR)
                pivot = moveElementToIndex(arr, pivot, pointerL);
            else
                pivot = moveElementToIndex(arr, pivot, pointerR);
            
            System.out.println(arr[pivot]);
            quickSort(arr, pivot-1, low);
            quickSort(arr, high, pivot+1);

        }
    }
    private static void swapElements(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
    private static int moveElementToIndex(int[] arr, int start, int end){
        int temp;
        int newIndex = start;
        if(start <= end){
            for(int i = start; i < end; i++) {
                temp = arr[newIndex+1];
                arr[newIndex+1] = arr[newIndex];
                arr[newIndex] = temp;
                newIndex++;
            }
            return newIndex;
        }
        else{
            for(int i = start; i > end; i--) {
                temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
                newIndex--;
            }
            return newIndex;
        }
    }
    public static void printArr(int[] arr){
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