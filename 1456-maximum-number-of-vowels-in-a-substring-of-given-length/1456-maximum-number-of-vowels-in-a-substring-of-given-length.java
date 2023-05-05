class Solution {
    public int maxVowels(String s, int k) {
        int len = 0;
        for(int i = 0; i < k; i++){
            if(i == s.length()){
                break;
            }
            
            if(isVoval(s.charAt(i))){
                len++ ;
            }
        }
        
        int max = len;
        for(int i = k; i < s.length(); i++){
            
            if(isVoval(s.charAt(i-k))){
                len-- ;                
            }
            
            if(isVoval(s.charAt(i))){
                len++ ;
            }
            
            max = Math.max(max,len);
        }
        
        return max;
    }
    
    private boolean isVoval(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        
        return false;
    }
}