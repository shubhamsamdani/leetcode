class Solution {
    public int missingNumber(int[] nums) {
        int xor = 1;
        int n = nums.length;
        for(int i = 2; i <= n; i++){
            xor = xor^i;
        }
        
        int xorArr = nums[0];
        for(int i = 1; i < n; i++){
            xorArr ^= nums[i];
        }
        
        return xorArr ^ xor;
    }
}