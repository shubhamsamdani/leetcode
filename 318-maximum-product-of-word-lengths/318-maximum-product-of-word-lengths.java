class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int arr[] = new int[words.length];
        for(int i = 0; i < words.length; i++){
            arr[i] = getWordBit(words[i]);
        }
        
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if((arr[j] & arr[i]) == 0){
                    max = Math.max(max,(words[i]).length() * (words[j]).length());
                }
            }
        }
        
        return max;
    }
    
    private int getWordBit(String word){
        char[] arr = word.toCharArray();
        int sum = 0;
        for( char c : arr){
            int index = c - 'a';
            sum |= 1 << index ;
        }
        
        return sum;
    }
}