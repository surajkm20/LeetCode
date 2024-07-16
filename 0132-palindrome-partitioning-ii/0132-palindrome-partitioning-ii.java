class Solution {
    public static boolean Palindrome(String str, int startIndex, int endIndex) {
        // Ensure indices are within bounds
        if (startIndex < 0 || endIndex >= str.length() || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid start or end index");
        }

        // Check palindrome
        while (startIndex < endIndex) {
            if (str.charAt(startIndex) != str.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }

    int func(String s, int ind, int[]dp){
        if(ind == s.length()) return 0;

        if(dp[ind] != -1) return dp[ind];
        int count = Integer.MAX_VALUE;
        for(int j=ind;j<s.length();j++){
            if(Palindrome(s, ind, j) == true){
                int cut = 1 + func(s, j+1, dp);
                count = Math.min(cut, count);
            }
        }

        return dp[ind] = count;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++) dp[i] = -1;
        return func(s, 0, dp)-1;
    }
}