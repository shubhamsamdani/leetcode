class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int h = n-1;
        int l = n-1;
        
        while(h > 0){
            if(nums[h-1] < nums[h]){
                //h--;
                break;
            }
            
            h-- ;
        }
        
        if(h == 0){
            reverseArray(nums,0,n-1);
            return;
        }
        
        h-- ;
        
        while(l > 0){
            if(h < l && nums[l] > nums[h]){
                //swap l and h
                int temp = nums[l];
                nums[l] = nums[h];
                nums[h] = temp;
                reverseArray(nums,h+1,n-1);
                return;
            }
            
            l-- ;
        }
    }
    
    
    private void reverseArray(int[] nums, int start, int end){
         while(start < end){
            int temp = nums[start];
            nums[start] = nums[end] ;
            nums[end] = temp;
            end--;
            start++;
        }
    }
}