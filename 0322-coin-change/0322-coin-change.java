class Solution {
    public int rec(int[] coins, int amount, int ind, int[][] dp){
        // base
        if(ind == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }
            return (int) Math.pow(10, 9);
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];

        // take
        int take = (int) Math.pow(10, 9);
        if(amount >= coins[ind]){
            take = 1 + rec(coins, amount-coins[ind], ind, dp);
        }

        int notTake = 0 + rec(coins, amount, ind-1, dp);

        return dp[ind][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<amount+1;j++){
                int take = (int) Math.pow(10, 9);
                if(j >= coins[i]){
                    take = 1 + dp[i][j-coins[i]];
                }

                int notTake = 0 + dp[i-1][j];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        return ans >= (int) Math.pow(10, 9) ? -1 : ans;
    }
}