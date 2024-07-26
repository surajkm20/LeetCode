class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            ArrayList<Integer> edges = adj.get(i);
            for(int j=0;j<edges.size();j++){
                indegree[edges.get(j)]++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
                ans.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int ele = queue.remove();
            
            for(int j : adj.get(ele)){
                indegree[j]--;
                if(indegree[j] == 0){
                    queue.add(j);
                    ans.add(j);
                }
            }
        }
        
        int[] fAns = new int[ans.size()];
        int j = 0;
        for(int i : ans){
            fAns[j] = i;
            j++;
        }
        
        return ans.size() == V;
    }
}