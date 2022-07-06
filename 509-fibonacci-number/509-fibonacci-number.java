class Solution {
    public int fib(int n){
        
        if( n < 2){
            return n;
        }
        
        int first = 0;
        int sec = 1;
        
        for(int i = 2; i <= n; i++){
            int temp = sec;
            sec += first;
            first = temp;
        }
        return sec;
    }
}