class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            } else{
                if(stack.peek() + 32 == c || stack.peek() - 32 == c){
                    stack.pop();
                    continue;
                }
                
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(Character c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}