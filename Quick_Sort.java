import java.util.Scanner;


public class Quick_Sort {
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }


    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for (int j = low; j <= high-1; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return (i+1);
   }
   
   
    static void quickSort(int[] arr, int low, int high){

        if (low < high){
            
            int par = partition(arr, low, high);
            
            quickSort(arr, low, par-1);
            quickSort(arr, par+1, high);
        }       
    }


    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();

        System.out.println("Enter the array elements : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before sorting : ");
        printArray(arr);

        System.out.println("After sorting : ");
        quickSort(arr, 0, n-1);
        printArray(arr);
    }   
}








