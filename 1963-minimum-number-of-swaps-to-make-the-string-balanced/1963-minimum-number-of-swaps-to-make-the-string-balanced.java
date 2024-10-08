class Solution {
    public int minSwaps(String s) {
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                s1.push(c);
            } else if(c == ']' && !s1.isEmpty() && s1.peek() == '['){
                s1.pop();
            }
        }
        
        return s1.size()/2 + s1.size()%2 ;
    }
}