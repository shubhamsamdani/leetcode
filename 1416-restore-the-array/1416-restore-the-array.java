class Solution {
    int mod = (int)1e9 + 7;
    public int numberOfArrays(String s, int k) {
        if (s == null || s.length() == 0)     return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // initial 
        for (int i = n - 1; i >= 0; i--) {
            long num = s.charAt(i) - '0'; // long
            if (num != 0) {
                for (int j = i + 1; j <= n; j++) {
                    if (num > k)    break;
                    dp[i] = (dp[i] + dp[j]) % mod;
                    if (j < n) {
                        num = num * 10 + s.charAt(j) - '0';
                    }
                }
            } else {
                dp[i] = 0;
            }
        }

        return dp[0];
    }
}