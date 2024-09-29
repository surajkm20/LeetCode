class Solution {
    public int rec(int[][] grid, int prev, int row, int[][] dp){
        // base
        if(row == grid.length) return 0;

        if(dp[row][prev+1] != -1) return dp[row][prev+1];

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            if(i == prev) continue;

            mini = Math.min(mini, grid[row][i] + rec(grid, i, row+1, dp));
        }
        return dp[row][prev+1] = mini;
    }
    public int minFallingPathSum(int[][] grid) {
        int rowL = grid.length;
        int colL = grid[0].length;
        int[][] dp = new int[rowL][colL+1];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<=colL;j++){
                dp[i][j] = -1;
            }
        }
        return rec(grid, -1, 0, dp);
    }
}