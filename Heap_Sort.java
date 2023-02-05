import java.util.Scanner;


public class Heap_Sort {
    
    static void heapSort(int[] arr, int n){

        // Build heap (rearrange array)
        for (int i = (n/2)-1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // swap the elements and heapify again
        for (int i = n-1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i){
        int largest = i;                        // parent node index position
        int l = i*2 + 1;                        // left child node index position
        int r = i*2 + 2;                        // right child node index position

        // If left child is larger than root
        if(l<n && arr[l]>arr[largest]){
            largest = l;
        }

        // If right child is larger than root
        if(r<n && arr[r]>arr[largest]){
            largest = r;
        }

        // If largest is not root
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("");
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
        printArray(arr, n);

        System.out.println("After sorting : ");
        heapSort(arr, n);
        printArray(arr, n);

    }
}
