class Solution {
    public int compress(char[] chars) {
        int start = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            int len = 1;
            i++ ;
            while(i < chars.length && chars[i] == c){
                len++ ;
                i++ ;
            }
            
            i-- ;
            if(len == 1){
                chars[start] = c;
                start++ ;
            } else{
                chars[start] = c;
                start++ ;
                int count = ledingZero(len);
                len = reverse(len);
                while(len > 0){
                    int x = len%10;
                    chars[start] = Character.forDigit(x, 10);
                    len /= 10;
                    start++ ;
                }
                
                while(count > 0){
                    chars[start] = '0';
                    count-- ;
                    start++ ;
                }
            }
        }
        
        return start;
    }
    
    private int ledingZero(int num){
        int count = 0;
        while(num%10 == 0){
            count++ ;
            num /= 10;
        }
        
        return count;
    }
    
    private int reverse(int num){
        int reverse = 0;  
        while(num != 0)   
        {  
        int remainder = num % 10;  
        reverse = reverse * 10 + remainder;  
        num = num/10;  
        }  
        
        return reverse;
    }
}