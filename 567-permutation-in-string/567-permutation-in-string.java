class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int n = s2.length();
        int[] arr = new int[26];
        
        if(len > n){
            return false;
        }
        
        for(char c : s1.toCharArray()){
            arr[c - 'a']++ ;
        }
        
        int i = 0;
        char[] str = s2.toCharArray();
        while(i < n){
            if( arr[str[i] - 'a'] > 0){
                int j = i;
                int[] arrCopy = arr.clone();
                int l = 0;
                while(j < n && arrCopy[str[j] - 'a'] > 0){
                    l++ ;
                    if(l == len){
                        return true;
                    }
                    arrCopy[str[j] - 'a']-- ;
                    j++ ;
                }
                
                if(l == len){
                        return true;
                }
            }
             i++ ;
        }
        
        return false;
    }
}