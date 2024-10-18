class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;
        int[] dp = new int[1 << 17];
        dp[0] = 1;

        for(int num : nums){
            for(int i = maxOrValue; i>=0; i--){
                dp[num | i] += dp[i];
            }
            maxOrValue |= num;
        }
        return dp[maxOrValue];
    }
}
