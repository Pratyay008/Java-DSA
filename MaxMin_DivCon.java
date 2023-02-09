import java.util.Scanner;

public class MaxMin_DivCon {
    
    static int max, min;
    
    static void max_min(int[] arr, int i, int j){
        int max1, min1;
        if(i==j){
            max = arr[i];
            min = arr[i];
        }
        else{
            if(i==j-1){
                if(arr[i]>arr[j]){
                    max = arr[i];
                    min = arr[j];
                }
                else{
                    max = arr[j];
                    min = arr[i];
                }
            }
            else{
                int mid = i+(j-i)/2;
                max_min(arr, i, mid);
                max1 = max; min1 = min;
                max_min(arr, mid+1, j);
                if(max1 > max){
                    max=max1;
                }
                if(min1 < min){
                    min=min1;
                }
            }
        }       
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
        
        max_min(arr, 0, arr.length-1);
     
        System.out.println("Maximum element is : "+ max);
        System.out.println("Minimum element is : "+ min);
    }
}
