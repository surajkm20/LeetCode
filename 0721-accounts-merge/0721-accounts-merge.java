class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(hashmap.containsKey(accounts.get(i).get(j))){
                    ds.unionByRank(hashmap.get(accounts.get(i).get(j)), i);
                }else{
                    hashmap.put(accounts.get(i).get(j), i);
                }
            }
        }

        for(int i=0;i<n;i++){
            List<String> temp = new ArrayList();
            temp.add(accounts.get(i).get(0));
            ans.add(temp);
        }

        for(Map.Entry<String, Integer> map : hashmap.entrySet()){
            ans.get(ds.findUPar(map.getValue())).add(map.getKey());
        }

        //System.out.println(hashmap.get("Hanzo6@m.co"));
        for(int i=0;i<n;i++){
            // System.out.println(ds.parent.get(i));
        }

        List<List<String>> finalAns = new ArrayList<>();
        for(List<String> tempAns : ans){
            if(tempAns.size() != 1){
                List<String> sublist = tempAns.subList(1, tempAns.size());  // Correct type
                Collections.sort(sublist);
                finalAns.add(new ArrayList<>(tempAns));
            }
        }

        return finalAns;
    }
}