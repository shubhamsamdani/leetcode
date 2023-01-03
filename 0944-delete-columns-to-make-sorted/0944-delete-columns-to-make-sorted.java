class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int len = strs[0].length();
        for(int j = 0; j < len; j++){
            for(int i = 1; i < strs.length; i++){
                if(strs[i-1].charAt(j) > strs[i].charAt(j)){
                    count++ ;
                    break;
                }
            }
        }
        
        return count;
    }
}