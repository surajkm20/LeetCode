class Solution {

    public int rec(int[] nums, int ind, int target, int[][] dp){
        if(ind == 0){
            if(target - nums[ind] == 0){
                return 1;
            }
            return 0;
        }

        if(target == 0){
            return 1;
        }

        if(dp[ind][target] != -1) return dp[ind][target];
        // nottake
        int notTake = rec(nums, ind-1, target, dp);

        //take
        int take = 0;
        if(nums[ind] <= target){
            take = rec(nums, ind-1, target-nums[ind], dp);
        }
        
        return dp[ind][target] = notTake | take;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        int target = sum/2;

        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        if(sum % 2 != 0) return false;
        return rec(nums, n-1, target, dp) == 1 ? true : false;
    }
}