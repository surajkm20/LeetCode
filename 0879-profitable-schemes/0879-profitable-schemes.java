class Solution {
    int mod=1000000007;
    public int rec(int n, int minProfit, int[] group, int[] profit, int ind, int sum, int[][][] dp, int num){
        // base
        if(sum >= minProfit && ind == group.length && num <= n){
            return 1;
        }

        if(ind >= group.length || num > n){
            return 0;
        }

        if(dp[ind][sum][num] != -1) return dp[ind][sum][num];

        return dp[ind][sum][num] = ((rec(n, minProfit, group, profit, ind+1, sum + profit[ind], dp, num+group[ind]))%mod + 
              (rec(n, minProfit, group, profit, ind+1, sum, dp, num)%mod))%mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sum = 0, gL = group.length;
        for(int i=0;i<gL;i++){
            sum += profit[i];
        }
        int[][][] dp = new int[gL][sum+1][n+1];
        for(int i=0;i<gL;i++){
            for(int j=0;j<sum+1;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return rec(n, minProfit, group, profit, 0, 0, dp, 0);
    }
}