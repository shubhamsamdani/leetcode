class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i = 0; i <= amount; i++){
            for(int e : coins){
                if(i - e >= 0 && dp[i-e] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i-e]);
                }
            }
        }
        
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        
        return dp[amount];
    }
}