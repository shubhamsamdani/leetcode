class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        if(n == 0){
            return -1;
        }
        
        if(n == 1){
            return nums[0];
        }
        for(int i = 1; i < n-1; i++){
            if(nums[i] != nums[i+1] && nums[i] != nums[i-1]){
                return nums[i];
            }
        }
        
        if(nums[0] == nums[1])
            return nums[n-1];
        
        return nums[0];
    }
}