class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return nums[0];
        }
        
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        
        int sum1 = getSum(nums,0,n-1);
        int sum2 = getSum(nums,1,n);
        
        return Math.max(sum1,sum2);
    }
    
    int getSum(int[] nums, int start, int end){
        int n = nums.length;
        int dp[] = new int[n];
        
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        
        for(int i = start+2; i < end; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        
        
        return dp[end-1];
    }
}
