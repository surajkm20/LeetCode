class Solution {
    public static boolean isPalindrome(String str, int startIndex, int endIndex) {
        // Extract the substring from startIndex to endIndex (inclusive)
        String substring = str.substring(startIndex, endIndex+1);

        int left = 0;
        int right = substring.length() - 1;

        // Check if the substring is a palindrome
        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if((isPalindrome(s, i, j) == true) && (j-i+1 > ans.length())){
                    System.out.println(" j value:"+j+", i value: "+i);
                    ans = s.substring(i, j+1);
                    //System.out.println(ans+" j value:"+j+" i value: "+i);

                }
            }
        }
        return ans;
        
    }
}