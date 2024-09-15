class Solution {
    boolean rec(String s, String p, int sInd, int pInd, int[][] dp) {
        // Base case: if both indices reach the end, it's a match
        if (sInd == s.length() && pInd == p.length()) {
            return true;
        }

        // If the pattern is exhausted but the string is not, it's not a match
        if (pInd == p.length()) {
            return false;
        }

        // Check if the result is already computed (memoized)
        if (dp[sInd][pInd] != -1) {
            return dp[sInd][pInd] == 1;
        }

        boolean match = (sInd < s.length()) && (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '.');

        boolean ans;

        // If the next character in the pattern is '*', handle zero or more matches
        if (pInd + 1 < p.length() && p.charAt(pInd + 1) == '*') {
            // Two options:
            // 1. Ignore the "x*" and move to the next part of the pattern
            // 2. If current characters match, consider moving the string index forward (consume the character)
            ans = rec(s, p, sInd, pInd + 2, dp) || (match && rec(s, p, sInd + 1, pInd, dp));
        } else {
            // Simple case: move both indices if characters match
            ans = match && rec(s, p, sInd + 1, pInd + 1, dp);
        }

        // Store the result in the dp table and return it
        dp[sInd][pInd] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        int[][] dp = new int[sL + 1][pL + 1];  // Adjust dp array size to handle s.length() == sInd and p.length() == pInd cases
        for (int i = 0; i <= sL; i++) {
            for (int j = 0; j <= pL; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(s, p, 0, 0, dp);
    }
}
