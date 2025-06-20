import java.util.Scanner;

public class InsertionSort {
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
        System.out.println("The array after: " + printArray(insertionSort(arr)));
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
