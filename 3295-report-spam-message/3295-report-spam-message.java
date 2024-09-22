class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(String s : message){
            hashmap.put(s, hashmap.getOrDefault(s, 0)+1);
        }

        int ans = 0;
        for(String s: bannedWords){
            if(hashmap.containsKey(s)){
                if(hashmap.get(s) > 0){
                    ans += hashmap.get(s);
                    hashmap.put(s, hashmap.getOrDefault(s, 0)-1);
                }
                

                if(ans >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}