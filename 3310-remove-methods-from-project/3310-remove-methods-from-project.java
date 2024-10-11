class Solution {
    public void susListDetect(List<List<Integer>> adjList, HashSet<Integer> susList, int k){
        
        for(int i=0;i<adjList.get(k).size();i++){
            if(!susList.contains(adjList.get(k).get(i))){
                susList.add(adjList.get(k).get(i));
                susListDetect(adjList, susList, adjList.get(k).get(i));
            }
        }

        return;
    }


    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<invocations.length;i++){
            adjList.get(invocations[i][0]).add(invocations[i][1]);
        }

        HashSet<Integer> susList = new HashSet<>();
        susList.add(k);

        // dfs
        susListDetect(adjList, susList, k);
        for(int j: susList){
            System.out.println(j);
        }
        System.out.println("...........");

        HashSet<Integer> ans = new HashSet<>();
        for(int i=0;i<invocations.length;i++){
            if (!susList.contains(invocations[i][0]) && susList.contains(invocations[i][1])) {
                for (int j = 0; j < n; j++) {  // Corrected the loop variable
                    ans.add(j);  // Added the element directly without condition
                }
                return new ArrayList<>(ans);
            }
        }

        for(int i=0;i<n;i++){
            if(!susList.contains(i)){
                ans.add(i);
            }

        }

        return new ArrayList<>(ans);
    }
}