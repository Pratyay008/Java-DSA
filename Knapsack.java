import java.util.*;
 
public class Knapsack {
    
    static float knapsack(float[] weight, float[] profit, int n, float m){
        float sum=0, max;
        int j=0;

        while(m > 0){
            max=0;
            for (int i = 0; i < n; i++) {
                if((profit[i] / weight[i]) > max){
                    max = profit[i] / weight[i];
                    j=i;
                }
            }

            if(weight[j] > m){
                System.out.println("Quantity of item number " +(j+1)+ " added is "+ m);
                sum = sum + (m*(profit[j] / weight[j]));
                break;
            }
            else{
                System.out.println("Quantity of item number " +(j+1)+ " added is "+ weight[j]);
                m = m - weight[j];
                sum = sum + profit[j];
                profit[j]=0;
            }
        }
    return sum;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items : ");
        int n = sc.nextInt();
        
        float[] weight = new float[n];
        float[] profit = new float[n];
        
        System.out.println("Enter the weights and profits of the Knapsack : ");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }
        
        System.out.println("Enter the maximum volume of the Knapsack : ");
        float m = sc.nextInt();

        float result = knapsack(weight, profit, n, m);
        System.out.println("The total profit is : "+ result);
   
    }  
}
