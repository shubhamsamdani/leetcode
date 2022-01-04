class Solution {
    public int bitwiseComplement(int n) {
        
        if(n == 0){
            return 1;
        }
        
        int multi = 1;
        int res = 0;
        while(n > 0){
            int binary = (n%2 == 0) ? 1 : 0;
            res = res + binary*multi;
            n /= 2;
            multi *= 2;
        }
        
        return res;
    }
}