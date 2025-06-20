public class SortingAlgorithms {
	public static void main(String[] args) {
		
		int[] unsorted = new int[]{1, 7, 0, 3, 4, 6};
		insertionSort(unsorted);
		
		bubbleSort(unsorted);
	
	    for(int i = 0; i < unsorted.length; i++) {
			System.out.print(unsorted[i] + " ");
		}
		
		selectionSort(unsorted);
	}
	
	public static void selectionSort(int[] arr){
		
        for (int j = 0; j < arr.length - 1; j++){
            int min = j;
            for (int i = j + 1; i < arr.length; i++){
                if (arr[min] > arr[i]){
                    min = i;
                }
            }
            int swap = arr[min];
            arr[min] = arr[j];
            arr[j] = swap;
            for (int x = 0; x < arr.length; x++){
                System.out.print(arr[x] + " ");
            }
            System.out.println();
        }
    }
	
	public static void insertionSort(int[] arr){
		
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                int target = j;
                int compare = i;
                while (compare >= 0 && arr[j] < arr[compare]){
                    target = compare;
                    compare--;
                }
                int swap = arr[j];
                for (int k = j; k > target; k--){
                    arr[k] = arr[k-1];
                }
                arr[target] = swap;
            }
            for (int r = 0; r < arr.length; r++){
				 System.out.print(arr[r] + " ");
            }
            System.out.println();
        }
    }
	
	public static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int swap = arr[i];
					arr[i] = arr[j];
					arr[j] = swap;
				}
			}
		}
	}
	
	public static int binarySearch(int[] arr, int element){
		
        int low = 0; //lowest element
        int high = arr.length; //highest element
        while (low <= high){
            int mid = (low + high) / 2; //we want the middle of the array. then we can determine
										// which half (right or left) to look at to find the element
            if (arr[mid] == element){
                return mid; //here if the mid element is actually the target element
            }
            else if (arr[mid] < element){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
	
	 public static int binarySearch(int[] arr, int element, int low, int high) { //recursively - when a method calls itself
		
		//base case - the code below doesn't happen if that condition is respected
        if (low > high) {
            return -1;
        }
		
        int mid = (low + high) / 2; //calculate the mid element
		
        if (arr[mid] == element) {
            return mid;
        }
		
		 //if mid is less than the target element, search the right half to find it.
		 // so now the lowest element will be, if we're ignoring all the elements before the mid and the mid itself, the element right after mid (mid + 1)
        else if (arr[mid] < element) {
            return binarySearch(arr, element, mid + 1, high); 
        } //here we want to search the left half
        else {
            return binarySearch(arr, element, low, mid - 1);
        }
    }
	
	//low = 0, high = length
	public static int[] mergeSort(int[] arr, int low, int high) {
	//recursion
	
		//base case 
		if(high - low == 1) {
			int[] newArr = new int[1];
			newArr[0] = arr[low];
			return newArr; //return value
		}
		
		int mid = (low + high) / 2;
		int[] left = mergeSort(arr, low, mid);
		int[] right = mergeSort(arr, mid, high);
		return merger(left, right); //return value
		
	}
	
	public static int[] merger(int[] left, int[] right) {
		int[] newArr = new int[left.length + right.length];
		int l = 0; //all must be initialized at 0!
		int r = 0;
		int i = 0;
		
		while(l < left.length && r < right.length) {
			if(right[r] > left[l]) {
				newArr[i] = left[l];
				l++;
			}
			else {
				newArr[i] = right[r];
				r++;
			}
			i++;
		}
		while(l < left.length) {
			newArr[i] = left[l];
			l++;
			i++;
		}
		while(r < right.length) {
			newArr[i] = right[r];
			r++;
			i++;
		}
	}
}