class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0;
		int max = Integer.MIN_VALUE;
		
		for(int num : nums){
			
			currMax += num;
            max = Math.max(max,currMax);
			if(currMax < 0){
				currMax = 0;
			} 		
		}
		
		return max;
    }
}