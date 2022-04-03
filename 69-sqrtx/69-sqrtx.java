class Solution {
    public int mySqrt(int x) {
        long i = 1;
        while(true){
            
            if(i*i == x){
                break;
            } else if(i*i > x){
                i-- ;
                break;
            }
            
            i++ ;
        }
        
        
        return (int)i;    
    }
}