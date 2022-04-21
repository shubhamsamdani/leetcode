class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int start = 1;
        int i = 0;
        int n = nums.length;
        
        for(i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                continue;
            }
            
            if(start != nums[i]){
                return start;
            }
            
            while(i < n-1 && nums[i+1] == nums[i]){
                i++ ;
            }
            
            start++ ;
        }
        
        return start;
    }
}