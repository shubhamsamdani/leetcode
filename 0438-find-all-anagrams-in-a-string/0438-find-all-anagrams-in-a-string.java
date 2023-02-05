class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
         int n = s1.length();
        int m = s2.length();
        
        if(n > m){
            return  new ArrayList<>();
        }
        
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++ ;
        }
        
        int[] temp = new int[26];
        for(int i = 0; i < n; i++){
            temp[s2.charAt(i) - 'a']++ ;
        }
        
        List<Integer> res = new ArrayList<>();
        

        for(int i = n; i < m; i++){
            
            
            if(isEqual(temp,freq)){
                res.add(i-n);
            }
            
            char charToRemove = s2.charAt(i - n);
            temp[charToRemove - 'a']-- ;
            temp[s2.charAt(i) - 'a']++ ;
        }
        
        if(isEqual(temp,freq)){
                res.add(m-n);
        }
        
        return res;
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