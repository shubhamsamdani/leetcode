class Solution {
    public String reverseWords(String s) {
        String strs[] = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(String str : strs){
            sb.append(getReverse(str));
             sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    
    String getReverse(String s){
        char arr[] =  s.toCharArray();
        int first = 0;
        int second = arr.length - 1;
        
        while(first < second){
            char temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            
            first++ ;
            second-- ;
        }
        
        return new String(arr);
    }
}