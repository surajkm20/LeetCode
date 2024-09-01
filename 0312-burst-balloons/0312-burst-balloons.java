class Solution {
    public int rec(int[] modi, int i, int j, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int ans = (modi[i-1] * modi[k] * modi[j+1]) + 
                        rec(modi, i, k-1, dp) + rec(modi, k+1, j, dp);
            
            maxi = Math.max(ans, maxi);
        }
        return dp[i][j] = maxi;

    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] modi = new int[n+2];
        modi[0] = 1;
        for(int i=0;i<n;i++){
            modi[i+1] = nums[i];
        }
        modi[n+1] = 1;

        int[][] dp = new int[modi.length][modi.length];
        for(int i=0;i<modi.length;i++){
            for(int j=0;j<modi.length;j++){
                dp[i][j] = -1;
            }
        }
        return rec(modi, 1, n, dp);
    }
}