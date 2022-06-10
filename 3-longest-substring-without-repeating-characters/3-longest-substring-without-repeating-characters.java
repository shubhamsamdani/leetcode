class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        for( int i = 0; i < n; i++){
            int j = i;
            while( j < n){
                if(map.get(s.charAt(j)) == null){
                    map.put(s.charAt(j),1);
                    j++;
                }else{
                    map.clear();
                    max = Math.max(max, j - i);
                    break;
                }
            }
            
            if(j == n){
               max = Math.max(max, j - i); 
            }
        }
        return max;
    }
}