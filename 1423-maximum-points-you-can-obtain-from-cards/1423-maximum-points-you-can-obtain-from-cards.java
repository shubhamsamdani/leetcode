class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int currSum = 0;
        
        for(int i = 0; i < k; i++){
            currSum += cardPoints[i];
        }
        
        maxSum = currSum;
        for(int i = 0; i < k; i++){
            currSum += -cardPoints[k-1-i] + cardPoints[cardPoints.length - 1 - i];
            maxSum = Math.max(maxSum,currSum);
        }
        
        return maxSum;
    }
}