class Solution {
    public int[] sortedSquares(int[] nums) {
        int first = 0;
        int second = 0;
        int n = nums.length;
        int res[] = new int[n];
        
        int p = 0;
        int i = 0;
        while(i < n && nums[i] < 0){
            i++ ;
        }
        
        first = i-1;
        second = i;
        
        while(p < n){
            if(first >= 0 && second < n && nums[first]*nums[first] < nums[second]*nums[second]){
                res[p] = nums[first]*nums[first];
                first-- ;
            } else if(first >= 0 && second < n && nums[first]*nums[first] >= nums[second]*nums[second]){
                res[p] = nums[second]*nums[second];
                second++ ;
            } else if(first >= 0){
                res[p] = nums[first]*nums[first];
                first-- ; 
            } else if(second < n){
                res[p] = nums[second]*nums[second];
                second++ ;
            }
            
            p++ ;
        }
        
        return res;
    }
}