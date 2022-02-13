class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        if(n <= 1){
            return count;
        }
        
        if(n == 2){
            if(nums[0] != nums[1]){
                return count;
            } else{
                return count+1;
            }
        }
        
        int basNumAtEven = Integer.MIN_VALUE;
        int basNumAtOdd = Integer.MAX_VALUE;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < n; i += 2){
            map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
            if(nums[i] > basNumAtEven){
                basNumAtEven = nums[i];
            }
        }
        basNumAtEven += 1;
        
        int max = 0;
        int numAtEven = basNumAtEven;
        for( Map.Entry<Integer,Integer> m : map1.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
                numAtEven = m.getKey();
            }
        }
        
    
        max = 0;
        int numAtOdd = nums[1];
        for(int i = 1; i < n; i += 2){
            map2.put(nums[i], map2.getOrDefault(nums[i],0)+1);
            if(basNumAtOdd > nums[i]){
                basNumAtOdd = nums[i];
            }
        }
        basNumAtOdd -= 1;
        
        for( Map.Entry<Integer,Integer> m : map2.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
                numAtOdd = m.getKey();
            }
        }
        
        if(numAtOdd == numAtEven){
            max = 0;
            if(map1.get(numAtEven) > map2.get(numAtOdd)){
                //find odd again
                for( Map.Entry<Integer,Integer> m : map2.entrySet()){
                    if(m.getValue() > max && m.getKey() != numAtEven){
                        max = m.getValue();
                        numAtOdd = m.getKey();
                    }
                }
                
            } else {
                //find even again
                for( Map.Entry<Integer,Integer> m : map1.entrySet()){
                    if(m.getValue() > max && m.getKey() != numAtOdd){
                        max = m.getValue();
                        numAtEven = m.getKey();
                    }
                }
            }
            
            if(numAtOdd == numAtEven && n%2 == 1){
                numAtOdd = basNumAtOdd;
            } else if(numAtOdd == numAtEven && n%2 == 0){
                numAtEven = basNumAtEven;
            }
        }
        
        
        for(int i = 0; i < n; i++){
            if(i%2 == 0 && nums[i] != numAtEven){
                nums[i] = numAtEven;
                count++ ;
            }
            
            if(i%2 == 1 && nums[i] != numAtOdd){
                nums[i] = numAtOdd;
                count++ ;
            }
        }
        
        return count;
    }
}