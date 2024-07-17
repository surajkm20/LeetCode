class Solution {
    public int func(int[] arr, int ind, int k, int[] dp){
        if(ind == arr.length) return 0;

        int mini = Integer.MIN_VALUE;
        int sum1 = Integer.MIN_VALUE;
        int l = 0;
        if(dp[ind] != -1) return dp[ind];
        for(int i = ind; i<Math.min(arr.length, ind+k);i++){
            l++;
            mini = Math.max(mini, arr[i]);
            int sum = (l * mini) + func(arr, i+1, k, dp);
            sum1 = Math.max(sum, sum1);
        }
        return dp[ind] = sum1;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++) dp[i] = -1;
        return func(arr, 0, k, dp);
    }
}