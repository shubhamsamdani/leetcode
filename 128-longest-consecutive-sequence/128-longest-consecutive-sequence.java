class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int max = 0;
        for(int num : nums){
            
            int right = num+1;
            int left = num-1;
            
            int countRight = 1;
            int countLeft = 0;
            
            while(set.contains(left)){
                countLeft++ ;
                set.remove(left);
                left-- ;
            }
            
            while(set.contains(right)){
                countRight++ ;
                set.remove(right);
                right++ ;
            }
            
            max = Math.max(max,countRight+countLeft);
        }
        
        return max;
    }
}