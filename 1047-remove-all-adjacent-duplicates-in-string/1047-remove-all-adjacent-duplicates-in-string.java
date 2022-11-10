class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s1.isEmpty()){
                s1.push(s.charAt(i));
            } else{
                if(s1.peek() == s.charAt(i)){
                    s1.pop();
                } else{
                    s1.push(s.charAt(i));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(char c : s1){
            sb.append(c);
        }
        
        return sb.toString();
        
    }
}