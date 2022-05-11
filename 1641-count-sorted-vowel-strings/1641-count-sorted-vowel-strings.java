class Solution {
    public int countVowelStrings(int n) {
        int dp[] = new int[]{1,1,1,1,1};
        
        int ans = 0;
        
        for(int i = 2; i <= n; i++){
            for(int j = 3; j >= 0; j--){
                dp[j] = dp[j]+dp[j+1];
            }
        }
        
        for(int el : dp){
            ans += el;
        }
        
        
        return ans;
    }
}