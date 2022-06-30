class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int median = nums[len/2];
        
        int res = 0;
        for(int i = 0; i < len; i++){
            res += Math.abs(nums[i] - median);
        }
        
        return res;
    }
}