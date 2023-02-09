import java.util.Scanner;

public class MaxMin_Simple {

    static void max_min(int[] arr, int n, int start, int end){
        int max = arr[0], min = arr[0];
        for(int i : arr){
            if(i>=max)
                max=i;
            if(i<=min) 
                min=i;   
        }
        System.out.println("Maximum element is : "+ max);
        System.out.println("Minimum element is : "+ min);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        max_min(arr, arr.length, 0, arr.length-1);
     
    }
}
