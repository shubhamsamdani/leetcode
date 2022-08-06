class Solution {
    public long countBadPairs(int[] nums) {
        long res = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = i - nums[i];
        }
        
        for(int i=n-1;i>=0;i--){
            res += Math.max(0, n-i-1-map.getOrDefault(nums[i], 0));
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        
        return res;
    }
}