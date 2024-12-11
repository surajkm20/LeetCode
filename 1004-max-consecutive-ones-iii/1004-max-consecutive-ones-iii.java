class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, r=0,l=0, count=0, ans=0;

        while(l<n){
            if(nums[l] == 0){
                k--;
            }

            if(k<0){
                if(nums[r] == 0){
                    k++;
                }
                r++;
            }
            l++;
        }
        return l-r;
    }
}