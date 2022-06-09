class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int first = 0;
        int second = numbers.length-1;
        
        while(first < second){
            if(numbers[first] + numbers[second] == target){
                if(first != second){
                    return new int[]{first+1,second+1};    
                }
                
            } else if(numbers[first] + numbers[second] < target){
                first++ ;
            } else{
                second-- ;
            }
        }
        
        return new int[]{0,0};
    }
}