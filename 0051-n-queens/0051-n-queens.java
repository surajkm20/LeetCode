class Solution {
    public boolean conditionCheck(char[][] board, int row, int col){
        int n = board.length;
        // col check
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // diagonal left
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        // diagonal right 
        i = row;
        j = col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
        
    }
    private void func(char[][] board, int ind, int size, List<List<String>>ans){
        // base
        if(ind == size){
            List<String> list = new ArrayList<>();

            for (char[] row : board) {
                list.add(new String(row));
            }
            ans.add(list);
        }

        for(int i=0;i<size;i++){
            if(conditionCheck(board, ind, i) == true){
                board[ind][i] = 'Q';
                func(board, ind+1, size, ans);
                board[ind][i] = '.';
            }
        }
        return ;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        func(board, 0, n, ans);

        return ans;
    }
}