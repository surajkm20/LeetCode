class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> mini = new ArrayList<>();
        List<Integer> maxi = new ArrayList<>();

        for(int[] row: matrix){
            int m = Integer.MAX_VALUE;
            for(int i : row){
                m = Math.min(m, i);
            }
            mini.add(m);
        }

        for(int i=0;i<matrix[0].length;i++){
            int m = Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                m = Math.max(matrix[j][i], m);
            }
            maxi.add(m);
        }

        // Create a copy of list1 to retain common elements
        ArrayList<Integer> commonElements = new ArrayList<>(maxi);

        // Retain only the elements that are also in list2
        commonElements.retainAll(mini);

        return commonElements;
    }
}