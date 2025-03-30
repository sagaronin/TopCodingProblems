package dp;

public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println("All possible ways to climb stairs: "+cs.climbStairs(4));
    }
    public int climbStairs(int n) {
        // this is a classic DP problem
        //ALL DP problems can be solved in 4 ways
        //1. Recursion
        // if(n==0 || n==1)
        //     return 1;
        // return climbStairs(n-1)+climbStairs(n-2);

        //2. Memoization(with recursion)
        // int dp[] = new int[n+1];
        // for(int i=0;i<=n;i++){
        //     dp[i]=-1;
        // }
        // return climbStairsMemoization(n, dp);
        //3. Tabulation(without recursion)
        //return climbStairsTabulation(n);
        //4. Space optimized 
        return climbStairsSpaceOptimized(n);

    }

    private int climbStairsMemoization(int n, int[] dp){
        if(n==0 || n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = climbStairsMemoization(n-1,dp)+climbStairsMemoization(n-2,dp);
    }
    private int climbStairsTabulation(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int climbStairsSpaceOptimized(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev=1;
        int prev2=1;        
        for (int i = 2; i <= n; i++) {
            int cur = prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}
