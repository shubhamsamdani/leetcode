class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        Map<Integer, List<Character>> treemap = 
               new TreeMap<>(Collections.reverseOrder());
        
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            char c = m.getKey();
            int v = m.getValue();
            
            List<Character> list = treemap.getOrDefault(v,new ArrayList<>());
            list.add(c);
            
            treemap.put(v,list);
        }
        
        StringBuilder sb = new StringBuilder("");
        for(Map.Entry<Integer,List<Character>> m : treemap.entrySet()){
            int freq = m.getKey();
            List<Character> str = m.getValue();
            
            for(char c : str){
                int i = 0;
                while(i < freq){
                    sb.append(c);
                    i++ ;
                }
            }
        }
        
        return sb.toString();
    }
}