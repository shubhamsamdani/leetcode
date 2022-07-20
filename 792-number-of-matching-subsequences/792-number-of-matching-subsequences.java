class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String,Integer> success = new HashMap<>();
        
        for(String word : words){
            
            if(success.containsKey(word)){
                count += success.get(word);
                continue;
            }
            
            if(isSubSequence(s,word)){
                count++ ;
                success.put(word,1);
            } else{
                success.put(word,0);
            }
        }
        
        return count;
    }
    
    private boolean isSubSequence(String s, String p){
        int n = s.length();
        int m = p.length();
        
        int i = 0, j = 0;
        
        while(j < m && i < n){
            if(s.charAt(i) == p.charAt(j)){
                i++ ;
                j++ ;
            } else{
                i++ ;
            }
        }
        
        if(j < m){
            return false;
        }
        
        return true;
    }
}