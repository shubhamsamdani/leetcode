class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length){
            return false;
        }
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < strs.length; i++){
            if(map.get(pattern.charAt(i)) != null){ 
               if(!map.get(pattern.charAt(i)).equals(strs[i]) ){
                return false;
                }
            }else{
                
                if(set.contains(strs[i]))
                    return false;
                else{
                    map.put(pattern.charAt(i), strs[i]);    
                    set.add(strs[i]);     
                }
            }
        }
        
        return true;
    }
}