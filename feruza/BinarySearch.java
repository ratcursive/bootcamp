import java.util.Scanner;
public class BinarySearch {
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
    public static int binarySearch(int[] arr, int num, int low, int high){
        int mid = (low + high)/2;
        if(num == arr[mid]){
            return mid;
        }
		if(low <= high){
			if(num > arr[mid]){
				return binarySearch(arr, num, mid+1, high);
				}
			else{
				return binarySearch(arr, num, low, mid-1);
				}
			} 
		}
        return -1;
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
