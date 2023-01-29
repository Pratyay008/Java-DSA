import java.util.Scanner;

public class MergeSort {

    static void merge(int[] arr, int start, int mid, int end){
        int l1 = mid - start +1;
        int l2 = end - mid;

        int[] leftSubArray = new int[l1];
        int[] rightSubArray = new int[l2];

        for (int i = 0; i < l1; i++) {
            leftSubArray[i] = arr[start + i];
        }
        for (int j = 0; j < l2; j++) {
            rightSubArray[j] = arr[mid + 1 + j];
        }

        int i=0, j=0, k=start;

        while(i<l1 && j<l2){
            if (leftSubArray[i] <= rightSubArray[j]) {
                arr[k] = leftSubArray[i];
                i++;
                k++;
            }
            else{
                arr[k] = rightSubArray[j];
                j++;
                k++;
            } 
        }

        while(i<l1){
            arr[k] = leftSubArray[i];
            i++;
            k++;
        }

        while(j<l2){
            arr[k] = rightSubArray[j];
            j++;
            k++;
        }
    }


    static void sort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end-start)/2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
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
        int len = sc.nextInt();

        int[] arr = new int[len];
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSort ob = new MergeSort();
        System.out.println("The array before sorting : ");
        ob.printArray(arr);

        System.out.println("The array after sorting : ");
        ob.sort(arr, 0, len-1);
        ob.printArray(arr);


    }
    
}