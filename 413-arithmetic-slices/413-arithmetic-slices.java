class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        
        int count = 0;
        int[] arr = new int[n];
        
        for(int i = 2; i < n; i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                arr[i] = arr[i-1] + 1;
            } else{
                arr[i] = 0;
            } 
            
            count += arr[i];
        }
        
        return count;
    }
}