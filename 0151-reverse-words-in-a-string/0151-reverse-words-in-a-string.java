class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        String res = "";
        int n = s.length();
        String temp = "";
        for( int i = 0; i < n; i++){
            while(i < n && charArray[i] == ' '){
                i++;
            }
            
           
            while( i < n && charArray[i] != ' '){
                temp = temp + charArray[i];
                i++;
            }
            res = temp + " " + res;
            temp = "";
        }
        return res.trim();
    }
}