class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        
        int n = a.length() - 1;
        int m = b.length() - 1;
        
        while(n >= 0 && m >= 0){
            int first = (int)(a.charAt(n) - '0');
            int sec = (int)(b.charAt(m) - '0');
            
            int sum = (carry + first + sec)%2 ;
            carry = (carry + first + sec)/2 ;
            
            sb.append(sum);
            n-- ;
            m-- ;
        }
        
        while(n >= 0){
            int first = (int)(a.charAt(n) - '0');
            int sum = (carry + first)%2 ;
            carry = (carry + first)/2 ;
            
            sb.append(sum);
            n-- ;
        }
        
        while(m >= 0){
            int sec = (int)(b.charAt(m) - '0');
            
            int sum = (carry + sec)%2 ;
            carry = (carry + sec)/2 ;
            
            sb.append(sum);
            m-- ;
        }
        
        if(carry > 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}