class Solution {
    public boolean increasingTriplet(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int num : nums){
            Integer higher = bst.ceiling(num);
            if(higher != null){
                bst.remove(higher);
            }
            
            bst.add(num);
        }
        
        
        return bst.size() >= 3;
    }
}