class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            int mid = low + (high-low)/2;
            
            if(mid == nums.length-1){
                if(mid > 0 && nums[mid-1] < nums[mid]){
                    return mid;
                }
            }
            
            if(mid == 0){
                if(nums.length > 1 && nums[mid] > nums[mid+1]){
                    return mid;
                }
            }
            
            if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        
        return low;
    }
}