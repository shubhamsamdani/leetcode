class Solution {
    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer,Long> map = new HashMap<>();
        long ans = 0;
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0l) + 1);
        }
        
        for(int el1 : map.keySet()){
            for(int el2 : map.keySet()){
                int el3 = target - el1 - el2 ;
                if(map.containsKey(el3)){
                    long freq1 = map.get(el1);
                    long freq2 = map.get(el2);
                    long freq3 = map.get(el3);
                    
                    if(el1 == el2 && el2 == el3){
                        ans += (freq1*(freq1-1)*(freq1-2))/6;
                    } else if( el1 == el2 && el1 != el3){
                        ans += freq3*(freq1*(freq1 - 1))/2 ;
                    } else if(el1 < el2 && el2 < el3){
                        ans += (freq1*freq2*freq3);
                    }
                }
            }
            
            ans = ans%(1000000007);
        }
        
        return (int)(ans);
    }
}