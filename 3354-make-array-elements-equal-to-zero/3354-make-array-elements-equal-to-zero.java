class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i];
            suffix[(n-1)-i] = suffix[n-i] + nums[(n-1)-i];
        }

        // for(int i=0;i<n;i++){
        //     System.out.println(prefix[i]);
        //     System.out.println(suffix[(n-1)-i]);
        // }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                if(prefix[i] == suffix[i]){
                    ans += 2;
                }

                if(prefix[i] == suffix[i]+1){
                    ans++;
                }
                if(prefix[i]+1 == suffix[i]){
                    ans++;
                }

            }
        }
        return ans;
    }
}