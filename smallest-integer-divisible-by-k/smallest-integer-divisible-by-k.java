class Solution {
    public int smallestRepunitDivByK(int k) {
        long num = 0;
        for(int i = 1; i <= k; i++){
            num = (num*10 + 1)%k;
            if(num == 0){
                return i;
            }
        }
        
        return -1;
    }
}