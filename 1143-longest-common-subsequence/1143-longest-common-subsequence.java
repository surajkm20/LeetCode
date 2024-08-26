class Solution {

    public int rec(String text1, int t1, String text2, int t2, int[][] dp){
        // base
        if(t1 < 0 || t2 < 0) return 0;

        if(dp[t1][t2] != -1) return dp[t1][t2];

        int take = 0;
        int notTake = 0;
        if(text1.charAt(t1) == text2.charAt(t2)){
            take = 1 + rec(text1, t1-1, text2, t2-1, dp);
        }else{
            notTake = Math.max(rec(text1, t1-1, text2, t2, dp), rec(text1, t1, text2, t2-1, dp));
        }

        return dp[t1][t2] = take + notTake;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] dp = new int[t1+1][t2+1];
        for(int i=0;i<t1+1;i++){
            for(int j=0;j<t2+1;j++){
                // if(i == 0 || j == 0) dp[i][j] = 0;
                dp[i][j] = 0;
            }
        }
        //return rec(text1, t1-1, text2, t2-1, dp);

        for(int i=1;i<t1+1;i++){
            for(int j=1;j<t2+1;j++){
                int take = 0;
                int notTake = 0;
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    take = 1 + dp[i-1][j-1];
                }else{
                    notTake = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[t1][t2];
    }
}