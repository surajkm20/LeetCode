class Solution {
    public boolean checkIsAllStars(String s, int ind){
        for(int i=0;i<=ind;i++){
            if(s.charAt(i) != '*')return false;
        }
        return true;
    }
    public boolean rec(String s, int ind1, String p, int ind2, int[][] dp){
        // base
        if(ind1 < 0 && ind2 < 0) return true;
        else if(ind1<0 && ind2>=0) return checkIsAllStars(p, ind2);
        else if(ind2 < 0) return false;

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2] == 0 ? false: true;
        }

        // matching
        boolean match = false;
        boolean notMatchQ = false;
        boolean notMatchS = false;
        if(s.charAt(ind1) == p.charAt(ind2)){
            match = rec(s, ind1-1, p, ind2-1, dp);
        }else{
            if(p.charAt(ind2) == '?'){
                notMatchQ = rec(s, ind1-1, p, ind2-1, dp);
            }else if(p.charAt(ind2) == '*'){
                notMatchS = rec(s, ind1-1, p, ind2, dp) || rec(s, ind1-1, p, ind2-1, dp) || rec(s, ind1, p, ind2-1, dp);
            }else{
                return false;
            }
        }
        boolean ans = match || notMatchQ || notMatchS;
        dp[ind1][ind2] = ans ? 1 : 0;
        return ans;

    }
    public boolean isMatch(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        int[][] dp = new int[sL][pL];
        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        return rec(s, sL-1, p, pL-1, dp);
    }
}