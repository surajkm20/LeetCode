class Solution {
    public int subarraysWithKDistinctDD(int[] nums, int k) {
        int right = 0;
        int left = 0, n = nums.length, ans=0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        while(right < n){
            hashmap.put(nums[right], hashmap.getOrDefault(nums[right], 0)+1);

            while(hashmap.size()>k){
                if(hashmap.get(nums[left]) == 1){
                    hashmap.remove(nums[left]);
                }else{
                    hashmap.put(nums[left], hashmap.get(nums[left])-1);
                }
                left++;
            }
            ans += (right-left)+1;
            right++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctDD(nums, k) - subarraysWithKDistinctDD(nums, k-1);
    }
}