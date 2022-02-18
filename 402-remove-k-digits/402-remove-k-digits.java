class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        int n = arr.length;
        int i = 0;
        
        Stack<Character> s1 = new Stack<Character>();
        s1.push(arr[i]);
        i++ ;
        
        while(i < n && k > 0){
            while(k > 0 && !s1.isEmpty() && s1.peek() > arr[i]){
                s1.pop();
                k--;
            }
            
            s1.push(arr[i]);
            i++ ;
        }
        
        while(!s1.isEmpty() && k > 0){
            s1.pop();
            k-- ;
        }
        
        String res = "";
        while(!s1.isEmpty()){
            res = s1.pop() + res;
        }
        
        res = res + num.substring(i,num.length());
        
        i = 0;
        while(i < res.length()){
            if(res.charAt(i) == '0'){
                i++ ;
            } else{
                break;
            }
        }
        
        return res.substring(i, res.length()).length() == 0 ? "0"  : res.substring(i, res.length());
    }
}