class Solution {
    int rec(int amount, int[] coins, int ind, int[][] dp){
        if(amount == 0) return 1;
        // base
        if(ind == 0){
            if(amount % coins[0] == 0) return 1;
            return 0;
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];
        

        // take
        int take = 0;
        if(amount >= coins[ind]){
            take = rec(amount-coins[ind], coins, ind, dp);
        }

        int notTake = 0 + rec(amount, coins, ind-1, dp);

        return dp[ind][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(amount, coins, n-1, dp);
    }
}