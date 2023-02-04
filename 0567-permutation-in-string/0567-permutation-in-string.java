class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if(n > m){
            return false;
        }
        
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++ ;
        }
        
        int[] temp = new int[26];
        for(int i = 0; i < n; i++){
            temp[s2.charAt(i) - 'a']++ ;
        }
        
        for(int i = n; i < m; i++){
            
            if(isEqual(temp,freq)){
                return true;
            }
            
            char charToRemove = s2.charAt(i - n);
            temp[charToRemove - 'a']-- ;
            temp[s2.charAt(i) - 'a']++ ;
        }
        
        if(isEqual(temp,freq)){
                return true;
        }
        
        return false;
    }
    
    private boolean isEqual(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        
        return true;
    }
}