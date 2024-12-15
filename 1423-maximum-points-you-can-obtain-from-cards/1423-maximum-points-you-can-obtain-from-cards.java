class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = cardPoints[0];
        suffix[n-1] = cardPoints[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + cardPoints[i];
            suffix[n-i-1] = suffix[n-i] + cardPoints[n-i-1];
        }

        int maxi = -99;
        for(int i=0;i<=k;i++){
            int left=i;
            int right = k-left;
            int sum = 0;
            
            if(left > 0){
                sum += prefix[left-1];
            }

            if(right > 0){
                sum += suffix[n-right];
            }

            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }
}