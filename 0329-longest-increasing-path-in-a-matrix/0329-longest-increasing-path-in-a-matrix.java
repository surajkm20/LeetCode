class Solution {
    public int bfs(int[][] matrix, int row, int col, int[][] dp){
        
        int[] rowDir = {0,  0, -1, 1};
        int[] colDir = {-1, 1,  0, 0};

        if(dp[row][col] != -1) return dp[row][col];

        int maxi = 0;
        for(int i=0;i<4;i++){
            int tempRow = row + rowDir[i];
            int tempCol = col + colDir[i];
            if(tempRow >=0 && tempRow < matrix.length && tempCol >=0 && tempCol < matrix[0].length
                && matrix[row][col] < matrix[tempRow][tempCol]){
                maxi = Math.max(1 + bfs(matrix, tempRow, tempCol, dp), maxi);
            }
        }
        return dp[row][col] = maxi;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int rowL = matrix.length;
        int colL = matrix[0].length;
        int[][] dp = new int[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                dp[i][j] = -1;
            }
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                maxi = Math.max(1+bfs(matrix, i, j, dp), maxi);
            }
        }
        return maxi;
    }
}