import java.util.Scanner;

public class MergeSort {
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
        System.out.println("The array after: " + printArray(mergeSort(arr, 0, arr.length)));
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