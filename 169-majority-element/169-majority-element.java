class Solution {
    public int majorityElement(int[] nums) {
        int count = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for( int i : nums){
            int c = map.getOrDefault(i,0);
            c++ ;
            if(c > count){
                return i;
            }
            
            map.put(i,c);
        }
        
        return -1;
    }
}