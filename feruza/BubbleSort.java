import java.util.Scanner;

public class BubbleSort {
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
        System.out.println("The array after: " + printArray(bubbleSort(arr)));
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
