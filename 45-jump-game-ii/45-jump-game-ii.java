class Solution {
    public int jump(int[] nums) {
        int level = 0;
        int divider = 0;
        int maxIndex = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i > divider){
                level++ ;
                divider = maxIndex;
            }
            
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        
        return level;
    }
}