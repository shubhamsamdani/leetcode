class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] res = new int[n];
        helper(requests,res,0, 0);
        return max;
    }
    
    private boolean resIsZero(int[] res){
        int count = 0;
        for(int el : res){
            if(el != 0) return false;
        }
        
        return true;
    }
    
    int max = 0;
    private void helper(int[][] requests, int[] res, int index, int count){
        if(index == requests.length){
            if(resIsZero(res)){
                max= Math.max(max,count);
            } 
            
            return;
        }
        
        helper(requests,res,index+1,count);
        res[requests[index][0]]-- ;
        res[requests[index][1]]++ ;
        
        helper(requests,res,index+1,count+1);
        res[requests[index][0]]++ ;
        res[requests[index][1]]-- ;

        
    }
}