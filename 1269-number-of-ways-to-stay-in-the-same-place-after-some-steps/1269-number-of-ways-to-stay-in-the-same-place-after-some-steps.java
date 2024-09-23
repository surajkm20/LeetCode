class Solution {
    int mod=1000000007;
    public int rec(int steps, int ind, int arrLen, int[][] dp){
        // base
        if(steps == 0 && ind == 0){
            return 1;
        }

        if(steps == 0 && ind != 0){
            return 0;
        }

        if(dp[steps][ind] != -1) return dp[steps][ind];

        // same position
        int samePos = rec(steps-1, ind, arrLen, dp)%mod;
        int left = 0;
        if(ind-1 >= 0){
            left = rec(steps-1, ind-1, arrLen, dp)%mod;
        }
        int right = 0;
        if(ind+1 < arrLen){
            right = rec(steps-1, ind+1, arrLen, dp)%mod;
        }

        return dp[steps][ind] = ((samePos + left)%mod + right)%mod;
    }
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps+1][steps+1];
        for(int i=0;i<=steps;i++){
            for(int j=0;j<=steps;j++){
                dp[i][j] = -1;
            }
        }
        return rec(steps, 0, arrLen, dp);
    }
}