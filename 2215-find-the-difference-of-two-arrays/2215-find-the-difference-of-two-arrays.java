class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int el : nums1){
            set.add(el);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> list1 = new HashSet<>();
        for(int el : nums2){
            if(set.contains(el)){
                continue;
            }
            
            list1.add(el);
        }
        
        
        
        set = new HashSet<>();
        for(int el : nums2){
            set.add(el);
        }
        
        Set<Integer> list2 = new HashSet<>();
        for(int el : nums1){
            if(set.contains(el)){
                continue;
            }
            
            list2.add(el);
        }
        
        res.add(new ArrayList<>(list2));
        res.add(new ArrayList<>(list1));
        
        return res;
        
    }
}