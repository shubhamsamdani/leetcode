class Solution {
    public String breakPalindrome(String p) {
        if(p.length() == 1) return "";
        char[] arr = p.toCharArray();
        
        int i = 0;
        boolean flag = true;
        
        for( i = 0; i < arr.length/2; i++){
            if(arr[i] == 'a') continue;
            
            arr[i] = 'a';
            flag = false;
            break;
        }
        
        if( i == arr.length/2 && flag == true){
            arr[ arr.length -1] = 'b';
        }
        
        return new String(arr);
    }
}