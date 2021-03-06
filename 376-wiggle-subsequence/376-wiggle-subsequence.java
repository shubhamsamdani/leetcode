class Solution {
    public int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                down = up + 1;
            } else if(nums[i] > nums[i+1]){
                up = down+1;
            }
        }
        
        return Math.max(up,down);
    }
}