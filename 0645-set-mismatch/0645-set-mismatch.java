class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 1; i <= n; i++){
            xor ^= i;
            xor ^= nums[i-1];
        }
        
        Arrays.sort(nums);
        
        int dup = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] == nums[i+1]){
                dup = nums[i];
                break;
            }
        }
        
        int[] res = new int[2];
        res[0] = dup;
        res[1] = dup^xor;
        
        return res;
        
    }
}