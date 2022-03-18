class Solution {
    public String removeDuplicateLetters(String s) {
        boolean visited[] = new boolean[26];
        int lastIndex[] = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Integer> s1 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a' ;
            
            if(visited[c]) continue;
            
            visited[c] = true;
            while(!s1.isEmpty() && s1.peek() > c && lastIndex[s1.peek()] > i){
                visited[s1.pop()] = false;
            }
            
            s1.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : s1){
            sb.append((char)(i + 'a'));
        }
        
        return sb.toString();
    }
}