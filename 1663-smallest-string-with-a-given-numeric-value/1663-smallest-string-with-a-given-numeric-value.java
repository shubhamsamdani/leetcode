class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for(int i = 0; i < n; i++){
            arr[i] = 'a';
        }
        
        int i = n-1;
        int curr = n;
        while(i >= 0 && curr < k){
            if(k - curr >= 26){
                curr = curr - 1 + 26;
                arr[i] = 'z';
            } else{
                //curr = curr - 1 + (k - curr);
                arr[i] = (char)('a' + k - curr);
                break;
            }
            
            i-- ;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(char c : arr){
            sb.append(c);
        }
        
        return sb.toString();
    }
}