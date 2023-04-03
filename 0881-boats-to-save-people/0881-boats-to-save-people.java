class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        
        int low = 0, high = n-1;
        int count = 0;
        for(int i = n-1; i >= low; i--){
            if(i == low){
                count++ ;
                break;
            }
            
            if(people[i] + people[low] <= limit){
                low++ ;
            }
            
            count++ ;
        }
        
        return count;
    }
}