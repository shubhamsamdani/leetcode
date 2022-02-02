class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        
        for(char c : p.toCharArray()){
            arr[c - 'a']++ ;
        }
        
        char[] str = s.toCharArray();
        for(int i = 0; i < m && i < n; i++){
            arr[str[i] - 'a']-- ;
        }
        
        if(checkAllZero(arr)){
            res.add(0);
        }
        
        for(int i = m; i < n; i++){
            arr[ str[i] - 'a']-- ;
            arr[str[i-m] - 'a']++ ;
            
            if(checkAllZero(arr)){
                res.add(i-m+1);
            }
        }
        
        return res;
    }
    
    private boolean checkAllZero(int[] a){
        for(int i = 0; i < 26; i++){
            if(a[i] != 0){
                return false;
            }
        }
        
        return true;
    }
}