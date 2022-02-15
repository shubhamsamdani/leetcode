class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        
         Map<String,Integer> map1 = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            Integer index = map.get(list2[i]);
            if(index != null){
                index += i;
                map1.put(list2[i],index);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(Map.Entry<String,Integer> m : map1.entrySet()){
            if(min > m.getValue()){
                min = m.getValue();
            }
        }
        
        for(Map.Entry<String,Integer> m : map1.entrySet()){
            if(min == m.getValue()){
                res.add(m.getKey());
            }
        }
        
        return res.toArray(new String[0]);
    }
}