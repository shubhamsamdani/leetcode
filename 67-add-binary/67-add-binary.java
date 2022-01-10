class Solution {
    public String addBinary(String a, String b) {
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        int i = a.length() - 1, j = b.length() - 1;
        int index = Math.min(i,j);
        while(i >= 0 && j >= 0){
            int c1 = a.charAt(i);
            int c2 = b.charAt(j);
            
            if(c1 == '1' && c1 == c2){
                sb.append(carry);
                carry = 1;
            } else if( c1 == '0' && c1 == c2){
                sb.append(carry);
                carry = 0;
            } else{
                if(carry == 1){
                    sb.append(0);
                    carry = 1;                        
                } else{
                    sb.append(1);
                }
            }
            
            i--;
            j--;
        }
        
        while(i >= 0){
            if(carry == 1){
                if(a.charAt(i) == '1'){
                    sb.append(0);
                } else{
                    sb.append(1);
                    carry = 0;
                }
            } else{
                sb.append(a.charAt(i));
            }
            i-- ;
        }
        
        while(j >= 0){
            if(carry == 1){
                if(b.charAt(j) == '1'){
                    sb.append(0);
                } else{
                    sb.append(1);
                    carry = 0;
                }
            } else{
                sb.append(b.charAt(j));
            }
            j-- ;
        }
        
        if(carry == 1){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}