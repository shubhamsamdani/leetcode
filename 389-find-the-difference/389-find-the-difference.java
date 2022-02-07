class Solution {
    public char findTheDifference(String s, String t) {
        char[] arr = t.toCharArray();
        int[] a = new int[26];
        
        for(char c : arr){
            a[c - 'a']++ ;    
        }
        
        for(char c : s.toCharArray()){
            a[c - 'a']-- ;
        }
        
        for(int i = 0; i < 26; i++){
            if(a[i] > 0){
                return (char)('a' + i);
            }
        }
        
        return 'a';
    }
}