
public class Binary_Search_recursive {
    
    static int BinarySearch(int[] arr, int target, int low, int high){
        if(low > high){
            return -1;
        }
        else{
            int mid = low + (high-low)/2;
            if(target > arr[mid]){
                return BinarySearch(arr, target, mid+1, high);
            }
            else if(target < arr[mid]){
                return BinarySearch(arr, target, low, mid-1);
            }
            else{
                return mid;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[]{2,4,6,7,9,10,14,19,23,26}; 
        int len = arr.length;
        int target = 19;
        int ans = BinarySearch(arr, target, 0, len-1);

        System.out.println("The index of the search element is : "+ans);
    }
}
