class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            int n = getNoOfSetBit(i);
            if(isPrime(n)){
                count++;
            }
        }
        return count;
    }
    
    private int getNoOfSetBit(int n){
        int count = 0;
        while(n > 0){
            if((n&1) == 1){
                count++ ;
            }
            
            n = n >> 1;
        }
        
        return count;
    }
    
    private boolean isPrime(int n){
        if( n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19){
            return true;
        }
        
        return false;
    }
}