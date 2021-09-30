class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for( int i : nums){
            sum += i;
        }
        
        if(sum%k != 0){
            return false;
        }
        
        if( k > nums.length){
            return false;
        }
        
        boolean[] bool = new boolean[nums.length];
        
        return canPartition(nums, bool,  0,  k,  0, sum/k);
    }
    
     boolean canPartition(int[] nums, boolean[] bool, int start, int k, int currSum, int subSetSum){
         if( k == 0) return true;
         if(currSum > subSetSum) return false;
         if(currSum == subSetSum){
             return canPartition(nums,bool,0,k-1,0,subSetSum);
         }
         
         for( int i = start; i < nums.length; i++){
             if(bool[i]) continue;
             bool[i] = true;
             if(canPartition(nums,bool,i+1,k,currSum + nums[i], subSetSum)){
                 return true;
             }
             bool[i] = false;
             
         }
         return false;
     }
}