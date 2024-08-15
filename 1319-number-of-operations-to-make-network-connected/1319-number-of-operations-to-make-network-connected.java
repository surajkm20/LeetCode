class DisjointSet{
    int[] parent;
    int[] rank;
    int[] size;
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int findUParent(int x){
        if(x == parent[x]) return x;

        parent[x] = findUParent(parent[x]);

        return parent[x];
    }
    public boolean find(int u, int v) {
        int upU = findUParent(u);
        int upV = findUParent(v);

        return upU == upV;
    }

    public void unionByRank(int u, int v) {
        int upU = findUParent(u);
        int upV = findUParent(v);

        if(rank[upU] > rank[upV]){
            parent[upV] = upU;

        }else if(rank[upU] < rank[upV]){
            parent[upU] = upV;
        }else{
            rank[upU]++;
            parent[upU] = upV;
        }
        return;
    }

    public void unionBySize(int u, int v) {
        int upU = findUParent(u);
        int upV = findUParent(v);

        if(size[upU] > size[upV]){
            parent[upV] = upU;
            size[upU] += size[upV];
        }else {
            parent[upU] = upV;
            size[upV] += size[upU];
        }
        return;
    }
}


class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int count = 0;
        for(int i=0;i<connections.length;i++){
            int u = ds.findUParent(connections[i][0]);
            int v = ds.findUParent(connections[i][1]);

            if(u != v){
                ds.unionByRank(u, v);
            }else{
                count++;
            }
        }

        int totalInd = 0;
        for(int i=0;i<n;i++){
            if(ds.parent[i] == i){
                totalInd++;
            }
        }
        totalInd--;
        if(count >= totalInd) return totalInd;
        return -1;
    }
}