class Solution {
    public int rec(String word1, int ind1, String word2, int ind2, int[][]dp){
        // base
        if(ind1 < 0 && ind2 < 0){
            return 0;
        }else if(ind1 < 0){
            return ind2+1;
        }else if(ind2 < 0){
            return ind1+1;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        // matched
        if(word1.charAt(ind1) == word2.charAt(ind2)){
            return dp[ind1][ind2] = rec(word1, ind1-1, word2, ind2-1, dp);
        }
        else{   // not matched
            // replace
            int replace = 1 + rec(word1, ind1-1, word2, ind2-1, dp);
            // insert
            int insert = 1 + rec(word1, ind1, word2, ind2-1, dp);
            // delete
            int delete = 1 + rec(word1, ind1-1, word2, ind2, dp);

            return dp[ind1][ind2] = Math.min(replace, Math.min(insert, delete));
        }
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return rec(word1, len1-1, word2, len2-1, dp);
    }
}