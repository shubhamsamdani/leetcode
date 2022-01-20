class Solution {
    public int search(int[] nums, int target) {
        
       int l = 0, h = nums.length-1;
       int pivot = findPivot(nums); 
       //System.out.println(pivot);
       
        if(nums[l] <= target && nums[pivot] >= target){
            h = pivot;
        } else{
            l = pivot+1;
        }
        
        while(l <= h){
            int mid = l + (h-l)/2 ;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid+1;
            } else{
                h = mid-1;
            }
        }
        
        return -1;
    }
    
    int findPivot(int[] nums){
        int n = nums.length;
        int l = 0, h = n - 1;
        while(l < h){
            int mid = l + (h-l)/2 ;
            if(mid + 1 < n && nums[mid] > nums[mid+1]){
                return mid;
            } else if (nums[mid] > nums[0]){
                l = mid+1;
            } else{
                h = mid;
            }
        }
        
        return l;
    }
}