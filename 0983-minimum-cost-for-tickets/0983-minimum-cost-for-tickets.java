class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for(int i = 0; i < 366; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int day : days){
            dp[day] = 0;
        }
        
        dp[0] = 0;
        for(int i = 1; i < 366; i++){
            if(dp[i] == Integer.MAX_VALUE){
                dp[i] = dp[i-1];
            } else{
                int cur = dp[i-1] + costs[0];
                cur = Math.min(cur, costs[1] + dp[Math.max(0, i - 7)]);
                cur = Math.min(cur, costs[2] + dp[Math.max(0, i - 30)]);
                dp[i] = cur;
            }
        }
        
        return dp[days[days.length-1]];
    }
}