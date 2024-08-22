class Solution {
    int funcRec(int[][] grid, int row, int col1, int col2, int[][][] dp){
        if(row >= grid.length || col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length){
            return 0;
        }

        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }
        int sum = (col1 != col2) ? grid[row][col1] + grid[row][col2] : grid[row][col1];
        int maxi = Integer.MIN_VALUE;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                maxi = Math.max(maxi, sum + funcRec(grid, row+1, col1+i, col2+j, dp));
            }
        }
        return dp[row][col1][col2] = maxi;
        
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=0;k<grid[0].length;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return funcRec(grid, 0, 0, grid[0].length-1, dp);
    }
}