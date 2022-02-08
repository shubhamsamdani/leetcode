class Solution {
    public int addDigits(int num) {
        int sum = 0;
        
        while(num > 0){
            int x = num;
            sum = 0;
            while(x > 0){
                sum += x%10;
                x /= 10;
            }
            
            num = sum;
            if(sum/10 == 0){
                break;
            }
        }
        
        return sum;
    }
}