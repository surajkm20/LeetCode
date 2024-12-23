class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = (int)1e9;
                }
            }
        }
        
        for(int[] edge: edges){
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][via]+matrix[via][j], matrix[i][j]);
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.println(matrix[i][j]);
        //     }
        // }
        
        int ans =Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=0;i<n;i++){
            int subAns = 0;
            for(int j=0;j<n;j++){
                if(i != j && matrix[i][j] != (int)1e9 && matrix[i][j] <= distanceThreshold){
                    subAns++;
                    System.out.println("subAns: "+subAns+" ind: "+j);
                }
            }
            System.out.println("subAns: "+subAns);

            // if(subAns <= ans && subAns!=0){
            //     ans = subAns;
            //     ind = i;
            // }
            // Update the result based on conditions
            if (subAns < ans || (subAns == ans && i > ind)) {
                ans = subAns;
                ind = i;
            }
        }
        return ind;
    }
}