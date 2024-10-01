class Solution {
    HashMap<Character, ArrayList<Character>> hashmap = new HashMap<>();
    ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    int mod = 1000000007;
    // Initialize HashMap inside the main method
    HashMap<Character, Integer> hashmap2 = new HashMap<>();
    public int rec(char ind, int k, int[][] dp){
        // base
        if(k == 1) {
            return 1;
        }

        if(dp[hashmap2.get(ind)][k] != -1){
            return dp[hashmap2.get(ind)][k];
        }

        ArrayList<Character> temp = hashmap.get(ind);
        int ans = 0;
        for(Character c : temp){
            ans = (ans + rec(c, k-1, dp))%mod;
        }

        return dp[hashmap2.get(ind)][k] = ans;
    }
    public int countVowelPermutation(int n) {
        int[][] dp = new int[5][n+1];
        for(int i=0;i<5;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }
        int ans = 0;
        // Define the rules for the character transitions
        hashmap.put('a', new ArrayList<>(Arrays.asList('e')));
        hashmap.put('e', new ArrayList<>(Arrays.asList('a', 'i')));
        hashmap.put('i', new ArrayList<>(Arrays.asList('a', 'e', 'o', 'u')));
        hashmap.put('o', new ArrayList<>(Arrays.asList('i', 'u')));
        hashmap.put('u', new ArrayList<>(Arrays.asList('a')));

        hashmap2.put('a', 0);
        hashmap2.put('e', 1);
        hashmap2.put('i', 2);
        hashmap2.put('o', 3);
        hashmap2.put('u', 4);
        

        for(int i=0;i<5;i++){
            ans = (ans + rec(vowels.get(i), n, dp))%mod;
        }
        return ans;
    }
}