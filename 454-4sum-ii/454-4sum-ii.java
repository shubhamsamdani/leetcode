class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map1 = new HashMap<>();
        
        int n = nums1.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sumAB = nums1[i] + nums2[j];
                
                map1.put(sumAB, map1.getOrDefault(sumAB,0)+1);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sumCD = nums3[i] + nums4[j];
                int sumAB = -sumCD;
                ans += map1.getOrDefault(sumAB,0);
            }
        }
        
        return ans;
    }
}