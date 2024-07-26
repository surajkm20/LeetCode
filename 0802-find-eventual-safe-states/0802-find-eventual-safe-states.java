class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        int[] outdegree = new int[V];
        for(int j=0;j<adj.length;j++){
            outdegree[j] = adj[j].length;
        }
        
        ArrayList<ArrayList<Integer>> outEdges = new ArrayList<>();
        for(int i=0;i<V;i++){
            outEdges.add(new ArrayList<>());
        }

        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].length;j++){
                outEdges.get(adj[i][j]).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(outdegree[i] == 0){
                queue.add(i);
                ans.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int ele = queue.remove();
            
            for(int j : outEdges.get(ele)){
                outdegree[j]--;
                if(outdegree[j] == 0){
                    queue.add(j);
                    ans.add(j);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}