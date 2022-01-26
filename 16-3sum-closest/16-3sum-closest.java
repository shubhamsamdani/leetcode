class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int currDiff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        
        for(int i = 0; i < n-2; i++){
            left = i+1;
            right = n-1;
            while(left < right){
               int temp = nums[left] + nums[right] + nums[i];
                if(temp == target){
                    return temp;
                }
                
            if(temp > target){
                right--;
            } else if(temp < target){
                left++ ;
            }
            
            if(currDiff > Math.abs(temp - target)){
                sum = temp;
                currDiff = Math.abs(temp - target);
            }
            
            if(left >= n || right < 0){
                break;
            } 
            }
        }
        
        return sum;
    }
}