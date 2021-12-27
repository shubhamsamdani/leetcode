class Solution {
    public int findComplement(int num) {
        int res = 0;
        int multi = 1;
        
        while(num > 0){
            int binary = (num%2 == 0) ? 1 : 0;
            num = num/2;
            res = res + binary*multi;
            multi *= 2;
        }
        
        return res;
    }
}