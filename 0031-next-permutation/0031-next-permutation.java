class Solution {
    void reverse1(int[] nums, int index2)
    {
        int i=1;
        while(index2<=(nums.length-i))
        {
            int temp = nums[index2];
            nums[index2] = nums[nums.length-i];
            nums[nums.length-i] = temp;

            i++;
            index2++;
        }
    }
    void swap(int[] nums, int index1, int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index1 = i;
                break;
            }
        }

        if(index1 != -1)
        {
            for(int i=n-1;i>index1;i--)
            {
                if(nums[i]>nums[index1])
                {
                    index2 = i;
                    swap(nums, index1, i);
                    break;
                }
            }
            reverse1(nums, index1+1);
        }
        else
        {
            reverse1(nums, 0);
        }
    }
}