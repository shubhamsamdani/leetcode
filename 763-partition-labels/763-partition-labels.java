class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int arr[] = new int[26];
        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(i < n){
            int start = i;
            int lastIndex = arr[s.charAt(i) - 'a'];
            for(int j = 0; j <= lastIndex; j++){
                lastIndex = Math.max(lastIndex, arr[s.charAt(j) - 'a']);
            }
            
            res.add(lastIndex - i + 1);
            i = lastIndex+1;
        }
        
        return res;
    }
}