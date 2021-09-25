class Solution {
    public int tribonacci(int n) {
        if( n == 0 || n == 1) return n;
        
        if( n == 2) return 1;
        
        int f=0;
        int s=1;
        int t=1;
        
        int res = 0;
        for( int i = 3; i <= n; i++){
            res = f+s+t;
            int tempA = t;
            t = res;
            int tempB = s;
            s = tempA;
            f = tempB;
        }
        
        return res;
    }
}