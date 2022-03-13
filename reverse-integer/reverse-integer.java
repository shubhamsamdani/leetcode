class Solution {
    public int reverse(int x) {
        int res = 0;
        int multi = 1;
        if(x < 0){
            multi = -1;
            x *= -1;
        }
        
        int prev = 0;
        while(x > 0){
            int num = x%10;
            prev = res;
            res = res*10 + num;
            
            if((res- num)/10 != prev){
                return 0;
            }
            
            x /= 10;
        }
        
               
        return multi*res;
    }
}