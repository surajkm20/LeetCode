class Solution {
    public int rec(String word1, String word2, int ind1, int ind2, int[][] dp){
        // base
        if(ind1 < 0 && ind2 < 0) return 0;
        else if(ind1 < 0) return ind2+1;
        else if(ind2 < 0) return ind1+1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        // matching
        int match = Integer.MAX_VALUE;
        int delete = Integer.MAX_VALUE;
        if(word1.charAt(ind1) == word2.charAt(ind2)){
            match = rec(word1, word2, ind1-1, ind2-1, dp);
        }else{
            int delete1 = 1 + rec(word1, word2, ind1-1, ind2, dp);
            int delete2 = 1 + rec(word1, word2, ind1, ind2-1, dp);
            delete = Math.min(delete2, delete1);
        }
        return dp[ind1][ind2] = Math.min(match, delete);
    }
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                dp[i][j] = -1;
            }
        }
        return rec(word1, word2, word1.length()-1, word2.length()-1, dp);
    }
}