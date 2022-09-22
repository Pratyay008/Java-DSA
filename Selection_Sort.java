import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {9,5,8,4,3,6,1};

        System.out.println("Before sorting the array is : ");
        System.out.println(Arrays.toString(arr));
        
        System.out.println("After selection sort the array is : ");
        // selection(arr);
        selectionSortEasy(arr);
        System.out.println(Arrays.toString(arr));

    }

//------- another method but difficult to understand-------

    // static void selection(int[] arr){
    //     for (int i = 0; i < arr.length; i++) {
    //         int last = arr.length-i-1;
    //         int maxIndex = getMaxIndex(arr, 0, last);
    //         swap(arr, maxIndex, last);
    //     }
    // }
    
    // static int getMaxIndex(int[] arr, int start, int end){
    //     int max = start;
    //     for (int i = start; i <= end; i++) {
    //         if(arr[max] < arr[i]){
    //             max = i;
    //         }
    //     }
    //     return max;
    // }

    // static void swap(int[] arr, int first, int second){
    //     int temp = arr[first];
    //     arr[first]= arr[second];
    //     arr[second]=arr[temp]; 
    // }



    static void selectionSortEasy(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
