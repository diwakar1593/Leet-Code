class Solution {
    public int minimumCost(int[] cost) {

        // Sort in descending order
        Arrays.sort(cost);

        int total = 0;
        int n = cost.length;

        // Traverse from largest to smallest
        for (int i = n - 1; i >= 0; i -= 3) {

            // Pay for the two most expensive candies
            total += cost[i];

            if (i -1 >= 0) {
                total += cost[i - 1];
            }

            // Every third candy is free
        }

        return total;
        
    }
}