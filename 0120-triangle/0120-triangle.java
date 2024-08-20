class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for(int i=1;i<triangle.size();i++){
            for(int j = 0; j<triangle.get(i).size();j++){
                int dia = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if(i-1 >= 0 && j-1 >= 0 ){
                    dia = triangle.get(i-1).get(j-1);
                }
                if(triangle.get(i-1).size() > j){
                    up = triangle.get(i-1).get(j);
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(dia, up));
            }
        }

        for(int i=0;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                System.out.println(triangle.get(i).get(j));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            ans = Math.min(triangle.get(triangle.size()-1).get(i), ans);
        }
        return ans;
    }
}