class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        
        for(int i = 0; i < n; i++){
            while(i < n-1 && prices[i+1] < prices[i]){
                i++ ;
            }
            
            int buy = prices[i];
            while(i < n-1 && prices[i+1] > prices[i]){
                i++ ;
            }
            
            int sell = prices[i];
            profit += sell - buy;
        }
        
        return profit;
    }
}