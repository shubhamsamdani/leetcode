class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(s1.isEmpty()){
                s1.push(c);
                continue;
            }
            
            if(c == ')' && '(' == s1.peek()){
                s1.pop();
            } else{
                s1.push(c);
            }
            
        }
        
        return s1.size();
    }
}