class Solution {
    public int partitionString(String s) {
        int count = 1;
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(freq[c-'a'] != 0){
                freq = new int[26];
                freq[c - 'a'] = 1;
                count++ ;
            } else{
                freq[c-'a'] = 1;
            }
        }
        
        
        return count;
    }
}