class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int left=0, ans=0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            // if present in hashmap
            if(hashmap.containsKey(ch)){
                int leftT = hashmap.get(ch)+1;

                for(int j=left;j<leftT;j++){
                    hashmap.remove(s.charAt(j));
                }
                left = leftT;
            }

            hashmap.put(ch, i);

            if(ans < (i-left)+1){
                ans = (i-left)+1;
            }
        }
        return ans;
    }
}