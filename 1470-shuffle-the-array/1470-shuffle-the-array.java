class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int i = 0; i < n; i++){
            a[i] = nums[i];
        }
        
        for(int i = n; i < 2*n; i++){
            b[i-n] = nums[i];
        }
        
        
        int i = 0;
        int first = 0;
        int sec = 0;
        while(i < 2*n){
            nums[i] = a[first];
            first++ ;
            i++ ;
            
            nums[i] = b[sec];
            sec++ ;
            i++ ;
        }
        
        return nums;
    }
}