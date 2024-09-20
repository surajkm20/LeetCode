class Solution {
    int mod=1000000007;
    public long rec(String[] words, int j, String target, int k, int[][] dp){
    
        if(k >= target.length()) return 1;
        if(j >= words[0].length() || (words[0].length()-j)<(target.length()-k)) return 0;

        if(dp[j][k] != -1) return dp[j][k];

        long sum = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].charAt(j) == target.charAt(k)){
                sum = (sum + rec(words, j+1, target, k+1, dp))%mod;
            }
        }
        sum = (sum + rec(words, j+1, target, k, dp))%mod;
        return dp[j][k] = (int)sum%mod;
    }
    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = words.length;
        int k = target.length();
        int[][] dp = new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                dp[i][j] = -1;
            }
        }
        return (int)rec(words, 0, target, 0, dp);
    }
}