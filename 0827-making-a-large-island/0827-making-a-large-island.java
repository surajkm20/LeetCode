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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        // ind = i*m+j
        DisjointSet ds = new DisjointSet(n*m);
        int[] vis = new int[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    vis[i*m+j] = 1;

                    // check for right
                    if((j+1) < m && grid[i][j+1] == 1){
                        ds.unionBySize(i*m+j, (i*m)+(j+1));
                    }

                    // check for left
                    if((j-1) >= 0 && grid[i][j-1] == 1){
                        ds.unionBySize(i*m+j, (i*m)+(j-1));
                    }

                    // check for Up
                    if((i-1) >= 0 && grid[i-1][j] == 1){
                        ds.unionBySize(i*m+j, ((i-1)*m)+j);
                    }

                    // check for left
                    if((i+1) < n && grid[i+1][j] == 1){
                        ds.unionBySize(i*m+j, ((i+1)*m)+j);
                    }
                }
            }
        }
        ans = ds.size.get(ds.findUPar(0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    int rightS = 0, rightParent = 0;
                    int leftS = 0, leftParent = 0;
                    int upS = 0, upParent = 0;
                    int downS = 0, downParent = 0;
                    HashSet<Integer> hashset = new HashSet<>();
                    // check for right
                    if((j+1) < m && grid[i][j+1] == 1){
                        rightParent = ds.findUPar((i*m)+(j+1));
                        if(!hashset.contains(rightParent)){
                            rightS = ds.size.get(rightParent);
                            hashset.add(rightParent);
                        }
                        
                    }

                    // check for left
                    if((j-1) >= 0 && grid[i][j-1] == 1){
                        leftParent = ds.findUPar((i*m)+(j-1));
                        if(!hashset.contains(leftParent)){
                            leftS = ds.size.get(leftParent);
                            hashset.add(leftParent);
                        }
                    }

                    // check for Up
                    if((i-1) >= 0 && grid[i-1][j] == 1){
                        upParent = ds.findUPar(((i-1)*m)+j);
                        if(!hashset.contains(upParent)){
                            upS = ds.size.get(upParent);
                            hashset.add(upParent);
                        }
                    }

                    // check for down
                    if((i+1) < n && grid[i+1][j] == 1){
                        downParent = ds.findUPar(((i+1)*m)+j);
                        if(!hashset.contains(downParent)){
                            downS = ds.size.get(downParent);
                            hashset.add(downParent);
                        }
                    }

                    ans = Math.max(ans, 1+downS+upS+leftS+rightS);
                }
            }
        }

        return ans;
    }
}