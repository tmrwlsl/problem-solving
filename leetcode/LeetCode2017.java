class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        long secondRowSum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            firstRowSum += grid[0][i];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            firstRowSum -= grid[0][i];

            ans = Math.min(
                    ans,
                    Math.max(firstRowSum, secondRowSum)
            );

            secondRowSum += grid[1][i];
        }
        return ans;
    }
}
