class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        
        int i = 0;
        while(i < costs.length && coins >= costs[i]){
            count++ ;
            coins -= costs[i];
            i++ ;
        }
        
        return count;
    }
}