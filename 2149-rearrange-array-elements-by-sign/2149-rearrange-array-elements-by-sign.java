class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int curr = 0;
        int first = 0, second = 0;
        int n = nums.length;
        
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                while(first  < n && nums[first] < 0){
                    first++ ;
                }
                
                res[i] = nums[first];
                first++ ;
            } else{
                while(second < n && nums[second] > 0){
                    second++ ;
                }
                
                res[i] = nums[second];
                second++ ;
            }
        }
        
        return res;
    }
}