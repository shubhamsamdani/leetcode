class Solution {
    public int arraySign(int[] nums) {
        int count = 0;
        int countNeg = 0;
        
        for(int el : nums){
            if(el < 0){
                countNeg++ ;
            }
            
            if(el == 0){
                return 0;
            }
        }
        
        if(countNeg%2 == 0){
            return 1;
        }
        
        return -1;
    }
}