class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        int n = adj.size();
        int[] indegree = new int[n];
        
        for(int i=0;i<n;i++){
            for(int num : adj.get(i)){
                indegree[num]++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.add(i);
                topo.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int ele = queue.remove();
            
            for(int num: adj.get(ele)){
                indegree[num]--;
                if(indegree[num] == 0){
                    queue.add(num);  
                    topo.add(num);
                }
            }
        }

        //Collections.sort(topo);
        topo.sort((a, b) -> a - b);
        return topo;
    }
}