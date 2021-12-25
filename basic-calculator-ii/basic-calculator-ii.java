class Solution {
    public int calculate(String s) {
        if(s.length() == 1){
            return (s.charAt(0) - '0');
        }
        
        int res = 0;
        char sign = '+';
        Stack<Integer> s1 = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            
            if(Character.isDigit(c)){
                res = res*10  + (c-'0');
            }
            
            if(isOperator(c)|| i == s.length()-1){
                if(sign == '+'){
                    s1.push(res);
                } else if(sign == '-'){
                    res *= -1;
                    s1.push(res);
                } else if(sign == '/'){
                    res = s1.pop()/res;
                    s1.push(res);
                } else if(sign == '*'){
                    res = s1.pop() * res;
                    s1.push(res);
                }

                res = 0;
                sign = c;
            } 
        }
        
        int ans = 0;
        while(!s1.isEmpty()){
            ans += s1.pop();
        }
        
        return ans;
    }
    
    private boolean isOperator(char c){
        if( c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
}