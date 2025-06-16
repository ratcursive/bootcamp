import java.util.Scanner;
public class App{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        boolean isRight = false;
        int[] arr = new int[4];
        for(int i = 0; i < arr.length; i++){
            isRight=false;
            while(!isRight){
                try{
                    System.out.println("Enter a random number");
                    arr[i] = Integer.parseInt(reader.nextLine());
                    isRight=true;
                }
                catch(IllegalArgumentException e){
                    System.out.println("Please enter a number!");
                }
            }
        }
        boolean answerCheck=false;
        int anw = 0;
        while(!answerCheck){
            try{
                System.out.println("Enter 1 for selection sort, 2 for Bubble sort, 3 for Insertion sort, 4 for Binary Search and 5 for Merge sort");
                anw = Integer.parseInt(reader.nextLine());
                answerCheck=true;
                if(anw > 5 || anw < 0){
                    System.out.println("Please enter a number between 1 and 5!");
                    anw = Integer.parseInt(reader.nextLine());
                    if(anw > 5 || anw < 0)
                        answerCheck=false;
                }
            }
            catch(IllegalArgumentException e){
                System.out.println("Please enter a number!");
                answerCheck=false;
            }
            
        }
        
        if(anw == 1){
            System.out.println("The array before: " + printArray(arr));
            System.out.println("The array after: " + printArray(selectionSort(arr)));
        }
        else if(anw == 2){
            System.out.println("The array before: " + printArray(arr));
            System.out.println("The array after: " + printArray(bubbleSort(arr)));
        }
        else if(anw == 3){
            System.out.println("The array before: " + printArray(arr));
            System.out.println("The array after: " + printArray(insertionSort(arr)));
        }
        else if(anw == 4){
            boolean numCheck = false;
            int num = 0;
            while(!numCheck){
                try{
                    System.out.println("Which number in your array would you like to find?");
                    num = Integer.parseInt(reader.nextLine());
                    numCheck = true;
                }
                catch(IllegalArgumentException e){
                    System.out.println("Please enter a number!");
                    num = Integer.parseInt(reader.nextLine());
                }
            }
            System.out.println("The sorted array: " + printArray(selectionSort(arr)));
            int pos = binarySearch(arr, num, 0, arr.length);
            if(pos < 0){
                System.out.println("This number is not in the array!");
            }
            else{
                System.out.println("The position of this number is "+pos);
            }
        }
        else{
            System.out.println("The array before: " + printArray(arr));
            System.out.println("The array after: " + printArray(mergeSort(arr, 0, arr.length)));
        }
        
    }
    public static int[] selectionSort(int[] arr){
        int swap = 0;
        int pos = 0;
        for(int i = 0; i<arr.length - 1; i++){
            pos = i;
            for(int j = i+1 ; j<arr.length; j++){
                if(arr[pos] > arr[j]){
                    pos = j;
                }
            }
            swap = arr[i];
            arr[i] = arr[pos];
            arr[pos] = swap;
        }
        return arr;
    }
    public static int[] bubbleSort(int[] arr){
        int swap=0;
        for(int j = 0; j < arr.length; j++){
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    swap=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=swap;
                }
            }
        }
        return arr;
    }
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int ps = i-1;
            int swap = arr[i];

            while(ps >= 0 && arr[ps] > swap){
                arr[ps+1] = arr[ps];
                ps -= 1;
            }
            arr[ps+1] = swap;
        }
        return arr;
    }
    public static int binarySearch(int[] arr, int num, int low, int high){
        int mid = (low + high)/2;
        if(num == arr[mid]){
            return mid;
        }
        try{
            if(num > arr[mid]){
                return binarySearch(arr, num, mid+1, high);
            }
            else{
                return binarySearch(arr, num, low, mid-1);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return -1;
        }   
    }
    public static int[] mergeSort(int[] arr, int low, int high){
        if(high-low==1){
            int[] newarr = new int[1];
            newarr[0] = arr[low];
            return newarr;
        }
        int mid = (high+low)/2;
        int[] left = mergeSort(arr, low, mid);
        int[] right = mergeSort(arr, mid, high);
        return merger(left, right);
    }
    public static int[] merger(int[] left, int[] right){
        int[] newarr = new int[left.length+right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while(l < left.length && r < right.length){
            if(right[r] > left[l]){
                newarr[i] = left[l];
                l++;
            }
            else{
                newarr[i] = right[r];
                r++;
            }
            i++;
        }
        while(r < right.length){
            newarr[i] = right[r];
            r++;
            i++;
        }
        while(l < left.length){
            newarr[i]=left[l];
            l++;
            i++;
        }
        return newarr;
    }
    public static String printArray(int[] array){
        String build="";
        for(int i = 0; i < array.length; i++){
            if(i == 0){
                build+="{" + array[i];
			}
            else if(i < array.length - 1){
                build+="," + array[i];
			}
            else{
                build+="," + array[i] + "}";
			}
        }
        return build;
    }
}