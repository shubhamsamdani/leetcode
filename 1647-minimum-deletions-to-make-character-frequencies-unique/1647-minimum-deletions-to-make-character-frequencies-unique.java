class Solution {
    public int minDeletions(String s) {
        Map<Integer,Integer> freq = new HashMap<>();
        int arr[] = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++ ;
        }
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            while(num > 0 && !set.add(num)){
                num-- ;
                count++ ;
            }
        }
        
        return count;
    }
    
    private void reverseArray(int[] arr){
        for(int i = 0; i < 13; i++){
            int temp = arr[i];
            arr[i] = arr[25-i];
            arr[25-i] = temp;
        }
    }
}