class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        int n = pattern.length();
        int m = strs.length;
        
        if(n != m){
            return false;
        }
        
        Map<Integer,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            char c = pattern.charAt(i);
            Integer pos = c - 'a';
            
            String temp = map.get(pos);
            if(temp != null){
                if(!temp.equals(strs[i])){
                    return false;
                }
            } else{
                
                if(set.contains(strs[i])){
                    return false;
                } else{
                    map.put(pos,strs[i]); 
                    set.add(strs[i]);
                }
                
            }
        }
        
        return true;
    }
}