class Solution {
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        long res = 0;
        int sign = 1;
        int index = 0;
        boolean signFound = false;
        boolean integerFound = false;
        while(index < arr.length && arr[index] == ' '){
            index++ ;
        }
        
        boolean foundFration = false;
        for(int i = index; i < arr.length; i++){
            //System.out.print( arr[i]+ ", ");
            if(arr[i] == ' '){
              break;  
            }
            else if(arr[i] == '-') {
                if(integerFound){
                    break;
                }
                
                if(signFound){
                    break;
                } else{
                    sign = -1;  
                    signFound = true;
                }
               
            } else if(arr[i] == '+'){
                if(integerFound){
                    break;
                }
                
                if(signFound){
                    break;
                } else{
                    sign = 1;
                    signFound = true;
                }
            }
            else if((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')){
                break;
            } else if(arr[i] == '.'){
                break;
            } else {
                res *= 10;
                res += (arr[i] - '0');
                integerFound = true;
                if(sign == 1 && res > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                } else if(sign == -1){
                    long temp = res;
                    temp = temp * -1;
                    if(temp < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
            }           
        }
        
        res = res * sign;
        int ans = (int)res;
        if(sign == 1 && res > Integer.MAX_VALUE){
            ans = Integer.MAX_VALUE;
        } else if(sign == -1 && res < Integer.MIN_VALUE){
            ans = Integer.MIN_VALUE;
        }
        
        return ans; 
    }
}