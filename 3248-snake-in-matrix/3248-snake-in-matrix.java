class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] mat = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        
        for(String str:commands){

            switch (str){
                case "DOWN":
                    startRow++;
                    break;
                case "RIGHT":
                    startCol++;
                    break;
                case "LEFT":
                    startCol--;
                    break;
                case "UP":
                    startRow--;
                    break;
            }  
        }

        return (startRow * n) + startCol;
    }
}