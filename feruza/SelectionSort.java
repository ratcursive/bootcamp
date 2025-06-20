import java.util.Scanner;

public class SelectionSort {
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
        System.out.println("The array before: " + printArray(arr));
        System.out.println("The array after: " + printArray(selectionSort(arr)));
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
