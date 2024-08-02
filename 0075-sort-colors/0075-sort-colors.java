class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
        return;
    }
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length-1;
        int n = nums.length;
        
        int i = 0;
        while(i<n){
            if(nums[i] == 0 && i >= zero){
                swap(nums, i, zero);
                zero++;
                i++;
            }
            else if(nums[i] == 2 && i <= two){
                swap(nums, i, two);
                two--;
            }else{
                i++;
            }
        }
        return;
        
    }
}