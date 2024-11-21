class Pair{
    int index;
    int value;

    Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ri = 0;

        Deque<Pair> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            int num = nums[i];

            while(!q.isEmpty() && q.peekLast().value < num){
                q.removeLast();
            }

            if(!q.isEmpty() && ((i-q.peekFirst().index)+1) > k){
                q.removeFirst();
            }
            

            q.addLast(new Pair(i, num));
            if(i >=k-1){
                ans[ri++] = q.peekFirst().value;
            }
        }

        return ans;

    }
}