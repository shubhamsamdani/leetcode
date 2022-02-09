class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){ 
                
                if(j+1 < n && nums[j+1] == nums[j]){
                    continue;
                }
                
                if(nums[j] - nums[i] == k){
                    count++ ;
                }
            }
            
            while(i+1 < n && nums[i+1] == nums[i]){
                i++;
            }
        }
        
        return count;
    }
}