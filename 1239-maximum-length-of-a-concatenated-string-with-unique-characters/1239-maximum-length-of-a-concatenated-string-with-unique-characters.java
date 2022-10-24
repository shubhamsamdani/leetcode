class Solution {
    
    int maxLen = 0;
    public int maxLength(List<String> arr) {
        helper(arr,0,"");
        return maxLen ;
    }
    
    
    void helper(List<String> list, int index, String res){
        if(index >= list.size()){
            return;
        }
        
        for(int i = index; i < list.size(); i++){
            if(isValid(res + list.get(i))){
                
                int len = res.length() + list.get(i).length();
                if(len > maxLen){
                    maxLen = len;
                }
                
                helper(list,i+1,res+list.get(i));
            }
        }
    }
    
    
    boolean isValid(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++ ;
            if(freq[c - 'a'] > 1){
                return false;
            }
        }
        
        return true;
    }
}