class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        k = k+1;
        int m = edges.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        
        
        // create adj matrix
        for(int i= 0;i<m;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2], 0});
        }
        for(int i=0;i<n;i++){
            for(int[] j: adj.get(i)){
                System.out.println(i+", , "+j[0]+", "+j[1]+", "+", "+j[2]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0});
        dist[src] = 0;
        
        while(!queue.isEmpty()){
            int[] ele = queue.remove();
            int num = ele[0];
            int lD = ele[1];
            int tempK = ele[2];
            System.out.println("\n");
            
            for(int[] j: adj.get(num)){
                if(dist[j[0]] > j[1] + lD  && tempK +1 <= k){
                    int sum = j[1] + lD;
                    int sum2 = tempK+1;
                    queue.add(new int[]{j[0], sum, sum2});
                    dist[j[0]] = j[1] +lD;
                }
            }
        }
        
        for(int i= 0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist[dst];
    }
}