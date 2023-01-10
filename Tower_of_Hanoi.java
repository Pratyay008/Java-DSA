import java.util.Scanner;

public class Tower_of_Hanoi {
   
   static void TOH(int n, char s, char d, char a){
        if(n==1)
            System.out.println("Move disk "+ n +" from "+ s +" to "+ d);
        else{
            TOH(n-1, s, a, d);
            System.out.println("Move disk "+ n +" from "+ s +" to "+ d);            
            TOH(n-1, a, d, s);
        }
   } 


    public static void main(String[] args) {
        
        System.out.println("------------------ Tower of Hanoi --------------------- ");

        int n;
        System.out.println("Enter the number of disks : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        TOH(n, 'S', 'D', 'A');

    }
}
