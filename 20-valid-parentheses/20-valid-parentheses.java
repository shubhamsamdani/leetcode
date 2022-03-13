class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray()){
            if( c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else{
                
                if(stack.isEmpty()){
                    return false;
                }
                char p = stack.pop();
                char t = getOpp(p);
                if( t != c){
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
    private char getOpp( char c){
        if( c == '('){
            return ')';
        }
        
        if( c == '['){
            return ']';
        }
        
        return '}';
    }
}