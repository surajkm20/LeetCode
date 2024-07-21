class Solution {
    public String getSmallestString(String s) {
        int n = s.length();
        String ans = new String(s);
        for(int i=0;i<n-1;i++){
            char[] charArray = s.toCharArray();
            if(((charArray[i]%2 == 0 && charArray[i+1]%2 == 0)
                || (charArray[i]%2 == 1 && charArray[i+1]%2 == 1)) && (int)charArray[i] > (int)charArray[i+1]){
                char temp = charArray[i];
                charArray[i] = charArray[i+1];
                charArray[i+1] = temp;
                String str = new String(charArray);
                return str;
            }
        }
        return ans;
    }
}