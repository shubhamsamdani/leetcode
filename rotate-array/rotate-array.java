class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        k = k%n;
        
        if(k == 0 || k == n) 
            return;
        
        int i = 0;
        int j = 0;
        
        while(n-k+i < n){
            res[i] = nums[n-k+i];
            i++ ;
        }
        
        while(i < n && j <= n-k){
            res[i] = nums[j];
            j++ ;
            i++ ;
        }
        
        int p = 0;
        for(int el : res){
            nums[p] = el;
            p++ ;
        }
    }
}