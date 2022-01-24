class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstCapital = false;
        boolean allSmall = false;
        boolean allCap = false;
        
        char[] arr = word.toCharArray();
        if(word.length() == 1){
            return true;
        }
        
        if(!('A' <= arr[0] && arr[0] <= 'Z')){
            allSmall = true;
        }
        
        if('A' <= arr[1] && arr[1] <= 'Z'){
            allCap = true;
        } else{
            firstCapital = true;
        }
        
        for(int i = 1; i < arr.length; i++){
            if(Character.isUpperCase(arr[i])){
                if(firstCapital)
                    return false;
                
                if(allSmall)
                    return false;
            } else if(Character.isLowerCase(arr[i])){
                if(allCap){
                    return false;
                }
            }
        }
        
        return true;
    }
}