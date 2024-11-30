class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] diff = new int[n+1];

        for(int[] qu : queries){
            int l = qu[0];
            int r = qu[1];
            int wt = 1;

            diff[l] += wt;
            diff[r+1] -= wt;
        }


        for(int i=1;i<n+1;i++){
            diff[i] += diff[i-1];
        }

        for(int i=0;i<n;i++){
            if(nums[i] > diff[i]) return false;
        }

        return true;
    }
}