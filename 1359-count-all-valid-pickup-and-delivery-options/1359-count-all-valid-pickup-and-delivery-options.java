class Solution {
    // Tc : O(n)
    // Sc : O(n)
    public int countOrders(int n) {
        long[] dp = new long[501];
        int mod = (int) Math.pow(10,9) + 7;
        dp[1]=1L;
        dp[2]=6L;
        for (int i=3;i<=n;i++) {
            int odddNo = 2 * i -1;
            int permutations = odddNo * (odddNo+1)/2;
            dp[i] = (dp[i-1]*(permutations))%mod;
        }
        return (int) dp[n];
    }

}