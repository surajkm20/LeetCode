class Solution {
    public int rec(String s, String t, int ind1, int ind2, int[][] dp){
        if(ind2 == t.length()){
            return 1;
        }
        
        if(ind1 == s.length()){
            return 0;
        }
        if(s.length()-ind1<t.length()-ind2){
            return 0;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        // if match
        int ans = 0;
        if(s.charAt(ind1) == t.charAt(ind2)){
            ans = rec(s, t, ind1+1, ind2+1, dp);
        }
        ans += rec(s, t, ind1+1, ind2, dp);

        return dp[ind1][ind2] = ans;
    }
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];
        for(int i=0;i<sLength;i++){
            for(int j=0;j<tLength;j++){
                dp[i][j] = -1;
            }
        }
        return rec(s, t, 0, 0, dp);
    }
}