class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] i 번째에서 최소 비용
        // dp[i] = min(dp[i-1]+cost[i-1],  dp[i-2] + cost[i-2])
        
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2 ; i < dp.length ; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2] + cost[i-2]);
        }
        
        return dp[cost.length];
    }
}