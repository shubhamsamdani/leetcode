class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(String str : strs){
            String key = getKey(str);
            List<String> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(str);
            map.put(key,temp);
        }
        
        for(Map.Entry<String,List<String>> m : map.entrySet()){
            res.add(m.getValue());
        }
        
        
        return res;
    }
    
    
    private String getKey(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}