class Solution {
    public int tribonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        
        if(n < 2){
            return n;
        }
        
        if(n == 2){
            return 1;
        }
        
        while(n >= 3){
            int temp_1 = third;
            int temp_2 = second;
            third = third + second + first;
            second = temp_1;
            first = temp_2;
            n-- ;
        }
        
        return third;
    }
}