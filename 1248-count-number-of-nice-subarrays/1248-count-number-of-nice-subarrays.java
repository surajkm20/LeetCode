class Solution {
    public int numberOfSubarraysA(int[] nums, int k){
        int right=0, left=0, count=0, n=nums.length, ans=0;

        while(right < n){
            count += nums[right]%2 !=0 ? 1 : 0;

            while(count>k){
                count -= nums[left]%2 !=0 ? 1 : 0;
                left++;
            }

            if(count <= k){
                ans += (right-left)+1;
            }
            right++;
        }

        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysA(nums, k) - numberOfSubarraysA(nums, k-1);
    }
}