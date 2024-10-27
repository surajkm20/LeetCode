// +1, -1, 0,   0
//  0,  0, +1, -1
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
class Solution {
    boolean bfs(int[][] grid1, int[][] grid2, int row, int col, HashSet<Pair> visitedGrid2){
        int n = grid2.length;
        int m = grid2[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int falseFlag = 0;
        visitedGrid2.add(new Pair(row, col));

        while(!queue.isEmpty()){
            int tRow = queue.peek().row;
            int tCol = queue.peek().col;
            queue.remove();

            for(int i=-1;i <= 1;i++){
                for(int j= -1;j<= 1;j++){
                    int newRow = tRow + i;
                    int newCol = tCol + j;
                    if(newRow >= n || newCol >= m || newRow < 0 || newCol < 0 || Math.abs(i) == Math.abs(j) || visitedGrid2.contains(new Pair(newRow, newCol)) || grid2[newRow][newCol] == 0){
                        continue;
                    }

                    if(grid2[newRow][newCol] == 1){
                        queue.add(new Pair(newRow, newCol));
                        if(grid2[newRow][newCol] == 1 && grid1[newRow][newCol] == 0){
                            falseFlag = 1;
                        }
                    }
                    visitedGrid2.add(new Pair(newRow, newCol));
                }
            }
        }
        return falseFlag == 0;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        HashSet<Pair> visitedGrid1 = new HashSet<>();
        HashSet<Pair> visitedGrid2 = new HashSet<>();
        int n = grid2.length;
        int m = grid2[0].length;
        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visitedGrid2.contains(new Pair(i, j)) && (grid2[i][j] == 1 && grid1[i][j] == 1) && (bfs(grid1, grid2, i, j, visitedGrid2)==true)){
                    System.out.println("row: "+i+" col: "+j);
                    ans++;
                }
            }
        }
        return ans;
    }
}