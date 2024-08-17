class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            indegree[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(indegree[i]);
        // }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.add(i);
                ans.add(i);
            }
        }

        while(!queue.isEmpty()){
            int top = queue.remove();

            for(int i=0;i<adj.get(top).size();i++){
                indegree[adj.get(top).get(i)]--;
                if(indegree[adj.get(top).get(i)] == 0){
                    queue.add(adj.get(top).get(i));
                    ans.add(adj.get(top).get(i));
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}