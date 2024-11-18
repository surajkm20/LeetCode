class Solution {
    public void nseGenerate(int[] arr, int[] nse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int nums = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= nums) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
    }

    public void pseeGenerate(int[] arr, int[] psee) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int nums = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= nums) {
                stack.pop();
            }

            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        // pse
        // nse
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n]; 
        pseeGenerate(heights, pse);
        nseGenerate(heights, nse);
        int ans = 0;

        for(int i=0;i<n;i++){
            int left = pse[i]+1;
            int right = nse[i];
            ans = Math.max((right-left) * heights[i], ans);
        }
        
        return ans;

    }
}