class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int n = s.length(), maxiF=0;

        int right=0, left=0, ans=0;
        while(right < n){
            int curr = s.charAt(right) - 'A';
            map[curr]++;
            maxiF = Math.max(maxiF, map[curr]);

            if(((right-left)+1)-(maxiF)>k){
                int currL = s.charAt(left)-'A';
                map[currL]--;
                left++;
            }else{
                ans = Math.max((right-left)+1, ans);
            }
            right++;
        }
        return ans;
    }
}