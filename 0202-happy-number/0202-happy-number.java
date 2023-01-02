class Solution {
    public boolean isHappy(int n) {
        
        if(n >= 2 && n <= 9 && n != 7){
            return false;
        }
        
        while(n != 1){
            n = getNewValue(n);
            //System.out.println(n);
            if(n >= 2 && n <= 9 && n != 7){
                return false;
            }
        }
        
        return true;
    }
    
    private int getNewValue(int num){
        
        int val = 0;
        while( num > 0){
            int temp = num%10 ;
            val += (temp*temp);
            num /= 10;
        }
        
        return val;
    }
}