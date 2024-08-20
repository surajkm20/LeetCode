class Solution {
    public int func(int m, int n, int[][] dp, int[][] obstacleGrid){
        if(m == 0 && n == 0) return 1;
        // base
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        // check for down and right
        return dp[m][n] = func(m-1, n, dp, obstacleGrid) + func(m, n-1, dp, obstacleGrid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        // for(int i=0;i<n;i++){
        //     dp[0][i] = 1;
        // }
        // for(int i=0;i<m;i++){
        //     dp[i][0] = 1;
        // }

        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //     }
        // }
        return func(m-1, n-1, dp, obstacleGrid);
        // func(m-1, n-1, dp, obstacleGrid);
        // return 

    }
}