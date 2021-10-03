class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        
        int i = 0;
        int maxReach = nums[i];
        
        while( maxReach >= i){
            if(maxReach >= n-1) return true;
            
            maxReach = Math.max(i + nums[i], maxReach);
            i++ ;
        }
        
        return false;
    }
}