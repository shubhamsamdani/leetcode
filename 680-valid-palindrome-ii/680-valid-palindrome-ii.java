class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int n = s.length();
        
        int A[] = new int[26];
        
        for(char c : s.toCharArray()){
            A[c-'a']++ ;
        }
        
        boolean deleted = false;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++ ;
                j-- ;
            } else if( !deleted && j > 0 && s.charAt(i) == s.charAt(j-1) 
                      && i < n-1 && s.charAt(i+1) == s.charAt(j)){
                if(A[s.charAt(i+1) - 'a'] % 2 == 0){
                    i += 2;
                    j-- ;
                } else{
                    j -= 2;
                    i++;
                }
                
                deleted = true;
                
            }else if( !deleted && j > 0 && s.charAt(i) == s.charAt(j-1)){
                deleted = true;
                j -= 2;
                i++ ;
            }
             else if(!deleted && i < n-1 && s.charAt(i+1) == s.charAt(j)){
                 i += 2;
                 j--;
                 deleted = true;
             } else if(deleted){
                 return false;
             }else{
                 return false;
             }
    }
        
        return true;
    }
}