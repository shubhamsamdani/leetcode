class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int start = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] p : pieces){
            map.put(p[0],p);
        }
        
        while(start < arr.length){
            if(map.containsKey(arr[start])){
                int[] val = map.get(arr[start]);
                for(int j = 0; j < val.length; j++){
                    if(val[j] == arr[start]){
                        start++ ;
                    } else{
                        return false;
                    }
                }
            } else{
                return false;
            }
            
            //start++ ;
        }
        
        return true;
    }
}