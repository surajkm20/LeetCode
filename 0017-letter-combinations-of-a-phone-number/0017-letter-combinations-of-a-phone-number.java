class Solution {
    public void func(String digits, int ind, String[] phoneString, List<String>ans, String str){
        if(str.length() == digits.length()){
            ans.add(str);
            return;
        }
        for(int i=0;i<phoneString[Character.getNumericValue(digits.charAt(ind))].length();i++){
            func(digits, ind+1, phoneString, ans, str+phoneString[Character.getNumericValue(digits.charAt(ind))].charAt(i));
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
             return ans;
        }
        String[] phoneString = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        func(digits, 0, phoneString, ans, "");
        return ans;
    }
}