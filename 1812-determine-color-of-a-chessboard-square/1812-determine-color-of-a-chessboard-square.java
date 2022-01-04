class Solution {
    public boolean squareIsWhite(String coordinates) {
        char[] c = coordinates.toCharArray();
        int first = c[0] - 'a';
        int sec = c[1] - '0';
        
        if(first%2 == 1){
            if(sec%2 == 0){
                return false;
            } else{
                return true;
            }
        } else{
            if(sec%2 == 1){
                return false;
            } else{
                return true;
            }
        }
    }
}