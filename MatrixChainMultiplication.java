import java.util.*;

public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] dimensions) {

        int n = dimensions.length;
        int[][] dp = new int[n][n];

        // Initialize dp[i][i] as 0 (since a single matrix has no multiplication cost)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        
        // Fill dp table diagonally
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // The final result is stored in dp[1][n-1]
        return dp[1][n - 1];
    }



    public static void main(String[] args) {

        int[] dimensions = {10, 30, 5, 60};
        int minCost = matrixChainOrder(dimensions);

        System.out.println("Minimum cost of matrix chain multiplication: " + minCost);

    }
}
