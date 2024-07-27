class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        int[] dist = new int[n+1];
        int[] vis = new int[n+1];
        int m = edges.length;
        int src = k;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
            vis[i] = 0;
        }
        
        // create adj matrix
        for(int i= 0;i<m;i++){
            //if(edges[i][0] != edges[i][1]){
                adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            //}
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        dist[src] = 0;
        
        while(!queue.isEmpty()){
            int[] ele = queue.remove();
            int num = ele[0];
            int lD = ele[1];
            
            for(int[] j: adj.get(num)){
                if(dist[j[0]] > j[1] + lD){
                    queue.add(new int[]{j[0], j[1] + lD});
                    dist[j[0]] = j[1] +lD;
                }
            }
        }
        
        int ans = -1;
        dist[src] = -1;
        for(int i= 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}