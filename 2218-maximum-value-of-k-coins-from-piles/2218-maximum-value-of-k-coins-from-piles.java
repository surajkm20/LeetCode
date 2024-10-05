class Solution {
    int rec(List<List<Integer>> piles, int row, int k, List<List<Integer>> dp) {
        // Base case: no coins left to take
        if (k == 0) return 0;
        // Base case: no more rows or no more coins in the current pile
        if (row == piles.size()) return 0;

        // Check if already computed
        if (dp.get(row).get(k) != -1) return dp.get(row).get(k);

        // Option 2: Don't take the current coin, move to the next pile
        int notTake = rec(piles, row + 1, k, dp);

        int sum = 0, take = 0;
        for (int i = 0; i < Math.min(k, piles.get(row).size()); i++) {
            sum += piles.get(row).get(i); // Add the i-th coin from current pile
            take = Math.max(take, sum + rec(piles, row + 1, k - (i + 1), dp));
        }

        // Store the best result in dp
        int temp = Math.max(notTake, take);
        dp.get(row).set(k, temp); 
        return temp;
    }


    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= piles.size(); i++) { // Create an outer list for each pile (size n+1)
            List<Integer> innerList = new ArrayList<>(); // Create a new inner list for this pile
            for (int l = 0; l <= k; l++) { // Initialize with size k+1
                innerList.add(-1); // Fill with -1 for uninitialized states
            }
            dp.add(innerList); // Add the inner list to the outer list
        }
        return rec(piles, 0, k, dp);
    }
}