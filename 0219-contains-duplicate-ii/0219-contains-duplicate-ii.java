class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = map.getOrDefault(nums[i],new ArrayList<>());
            if(!temp.isEmpty()){
                for(int el : temp){
                    if(Math.abs(i-el) <= k){
                        return true;
                    }
                }
            }
            
            temp.add(i);
            map.put(nums[i],temp);
        }
        
        return false;
    }
}