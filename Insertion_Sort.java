import java.util.Arrays;

public class Insertion_Sort {

    static void sort(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if (arr[j]<arr[j-1]) {
                    swap(arr, j-1, j);
                }
                else break;
            }           
        }  
    }

    // --------regular print method--------
    // static void printArray(int [] arr){
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println(" ");
    // }

    static void swap(int arr[], int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;

    }


    public static void main(String[] args) {
    
        int [] arr={5,2,3,7,-3,4,9,8,-6,1};
        System.out.println("Before sorting the array is : "+ Arrays.toString(arr));
        // printArray(arr);
        
        
        sort(arr);
        System.out.println("After sorting the array is : "+ Arrays.toString(arr));


    }
}
