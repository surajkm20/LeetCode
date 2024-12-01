class Solution {
    public int smallestNumber(int n, int t) {
        for(int j=n;j<=100;j++){
            String s = String.valueOf(j);
            int ans = 1;
            System.out.println(s+"..");
            for(int i=0;i<s.length();i++){
                ans *= s.charAt(i)-'0';
            }

            if(ans%t == 0){
                return j;
            }
        }
        return 0;
    }
}