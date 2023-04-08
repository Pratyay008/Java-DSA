import java.util.*;

class Job{
    char id;
    int deadline, profit;
    Job(char x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}


class Solve{

    int[] JobScheduling(Job[] arr, int n){
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));

        int maxi=0;
        for (int i = 0; i < n; i++) {
            if(arr[i].deadline > maxi){
                maxi=arr[i].deadline;
            }
        }

        int[] result = new int[maxi+1];
        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs=0, jobProfit=0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if(result[j] == -1){
                    result[j]=i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
}


public class JobSequencing {
    
    public static void main(String[] args){

        // Job[] arr = new Job[4];
        // arr[0] = new Job('a', 4, 20);
        // arr[1] = new Job('b', 1, 10);
        // arr[2] = new Job('c', 2, 40);
        // arr[3] = new Job('d', 2, 30);
        
        Job[] arr = new Job[5];
        arr[0] = new Job('a', 2, 100);
        arr[1] = new Job('b', 1, 19);
        arr[2] = new Job('c', 2, 27);
        arr[3] = new Job('d', 1, 25);
        arr[4] = new Job('e', 3, 15);
                        
                        
        Solve ob = new Solve();
        
        int[] res = ob.JobScheduling(arr, 5);
        System.out.println(res[0] + " " + res[1]);
    }
}
