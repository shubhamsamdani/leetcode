class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            int mid = low + (high-low)/2 ;
            if(mid > 0 && mid < nums.length-1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            } else if(mid < nums.length-1 && nums[mid] < nums[mid+1]){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        
        return low;
    }
}