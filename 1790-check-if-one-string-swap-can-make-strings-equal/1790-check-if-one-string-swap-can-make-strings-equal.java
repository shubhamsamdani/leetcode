class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] arr = new char[3];
        int[] index = new int[3];
        int n = s1.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        int j = 0;
        for(int i = 0; i < n; i++){
            if(str1[i] != str2[i]){
                arr[j] = str1[i];
                index[j] = i;
                j++ ;
            }
            
            if(j > 2){
                return false; 
            }
        }
        
        if(j == 0){
            return true;
        }
        
        char temp = str1[index[0]];
        str1[index[0]] = str1[index[1]];
        str1[index[1]] = temp;
        
        s1 = new String(str1);
        
        return s1.equals(s2);
    }
}