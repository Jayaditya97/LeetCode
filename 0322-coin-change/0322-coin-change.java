class Solution {
    public int solve(int coins[], int amount, int n, int[][] dp) {
        if(amount == 0) return 0;
        if(n == 0 || amount < 0) return Integer.MAX_VALUE - 1;
        if(dp[n][amount] != -1) return dp[n][amount];

        if(coins[n-1] <= amount){
            int inc = 1 + solve(coins, amount-coins[n-1], n, dp);
            int exc = solve(coins, amount, n-1, dp);
            return dp[n][amount] = Math.min(inc, exc);
        }
        else{
            return dp[n][amount] = solve(coins, amount, n-1, dp);
        }
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i = 0; i <= n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        int res = solve(coins, amount, n, dp);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }
}