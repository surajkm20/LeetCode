class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) return 0;
        int ans = 1;
        int tempAns = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1]+1 == nums[i]){
                tempAns++;
            }else if(nums[i-1] == nums[i]){
                continue;
            }
            else{
                tempAns = 1;
            }
            ans = Math.max(ans, tempAns);
            System.out.println(tempAns);
            System.out.println(nums[i-1]);
            System.out.println(nums[i]);
            System.out.println("---------------");
        }
        return ans;
    }
}