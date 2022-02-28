class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        
        if(n < 1){
            return res;
        }
        
        int start = 0;
        int end = 0;
        int i = 0;
        while(i < n){
            start = i;
            end = i;
            while(i+1 < n && nums[i+1] - nums[i] == 1){
                end = i+1;
                i++ ;
            }
            
            if(start == end){
                res.add("" + nums[start]);
            } else{
                String temp = nums[start] + "->" + nums[end];
                res.add(temp);
            }
            
            i++ ;
        }
                
        return res;
    }
}