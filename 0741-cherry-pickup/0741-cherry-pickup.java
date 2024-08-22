class Solution {
    int funcRec(int[][] grid, int row1, int col1, int row2, int col2, int[][][][] dp){
        if(row2 >= grid.length || row1 >= grid.length || col1 >= grid[0].length || col2 >= grid[0].length || grid[row1][col1] == -1 || grid[row2][col2] == -1){
            return Integer.MIN_VALUE;
        }

        if(dp[row1][col1][row2][col2] != -1){
            return dp[row1][col1][row2][col2];
        }

        if (row1 == grid.length - 1 && col1 == grid.length - 1)
            return grid[row1][col1];


        int sum = (col1 == col2 && row1 == row2) ? grid[row1][col1] : grid[row1][col1] + grid[row2][col2];
        int maxi = funcRec(grid, row1+1, col1, row2+1, col2, dp);
        maxi = Math.max(maxi, funcRec(grid, row1+1, col1, row2, col2+1, dp));
        maxi = Math.max(maxi, funcRec(grid, row1, col1+1, row2+1, col2, dp));
        maxi = Math.max(maxi, funcRec(grid, row1, col1+1, row2, col2+1, dp));

        dp[row1][col1][row2][col2] = (maxi == Integer.MIN_VALUE) ? Integer.MIN_VALUE : maxi + sum;
        return dp[row1][col1][row2][col2];
    }
    public int cherryPickup(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=0;k<grid.length;k++){
                    for(int l=0;l<grid[0].length;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return Math.max(0, funcRec(grid, 0, 0, 0, 0, dp));
    }
}