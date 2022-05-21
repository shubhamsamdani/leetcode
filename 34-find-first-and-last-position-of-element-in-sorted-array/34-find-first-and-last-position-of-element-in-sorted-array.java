class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int low = 0;
        int high = nums.length-1;
        
        if(nums.length == 0){
            return res;
        }
        
        int prev = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                high = mid-1;
                prev = mid;         
            } else if(nums[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        //System.out.println("high" + high);
        //System.out.println("low" + low);
        
        if(nums[prev] != target){
            return res;
        }
        
        res[0] = prev;
        
        high = nums.length-1;
        low = 0;
        prev = 0;
        //System.out.println("loop2");
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){  
                low = mid+1;
                prev = mid;
            } else if(nums[mid] > target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        
        res[1] = prev;
        return res;
    }
}