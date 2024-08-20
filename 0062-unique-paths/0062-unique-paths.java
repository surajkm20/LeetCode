class Solution {
    public int func(int m, int n, int[][] dp){
        if(m == 0 && n == 0) return 1;
        // base
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        // check for down and right
        return dp[m][n] = func(m-1, n, dp) + func(m, n-1, dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        //dp[m][n] = dp[m-1][n] + dp[m][n-1];
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        //return func(m-1, n-1, dp);
        return dp[m-1][n-1];
    }
}