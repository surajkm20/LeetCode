class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] dp = new int[t1+1][t2+1];

        for(int i=1;i<t1+1;i++){
            for(int j=1;j<t2+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[t1][t2];
    }

    public String reverses(String s2){
        String ans = "";
        for(int i = s2.length()-1;i>=0;i--){
            ans += s2.charAt(i);
        }
        return ans;
    }


    public int minInsertions(String s) {
        String s2 = reverses(s);
        int l = s.length();
        return l-longestCommonSubsequence(s, s2);
    }
}