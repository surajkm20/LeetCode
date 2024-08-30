class Solution {
    public int rec(String s, int ind1, String t, int ind2, int[][] dp){
        // base
        if(ind2 < 0) return 1;
        else if(ind1 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        // match
        int match = 0;
        int notMatch = 0;
        if(s.charAt(ind1) == t.charAt(ind2)){
            match = rec(s, ind1-1, t, ind2-1, dp) + rec(s, ind1-1, t, ind2, dp);
        }else{
            notMatch = rec(s, ind1-1, t, ind2, dp);
        }

        return dp[ind1][ind2] = match + notMatch;
    }
    public int numDistinct(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int[][] dp = new int[sL][tL];
        for(int i=0;i<sL;i++){
            for(int j=0;j<tL;j++){
                dp[i][j] = -1;
            }
        }
        return rec(s, sL-1, t, tL-1, dp);
    }
}