class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        k = k%n;
        
        if(k == 0 || k == n) return;
        int i = 0;
        int j = 0;
        
        while(i < n){
            if(i < n-k){
                res[i+k] = nums[i];
            } else{
                res[j] = nums[i];
                j++;
            }
            i++ ;
        }
        
        for(i = 0; i < n; i++){
            nums[i] = res[i];
        }
        
    }
}