class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        if(n == 1){
            return true;
        }
        
        int max = nums[0];
        int i = 1;
        while(max >= i){
            
            if(max >= n-1){
                return true;
            }
            
            max = Math.max(nums[i]+i,max);
            i++ ;
        }
        
        return false;
        
    }
}