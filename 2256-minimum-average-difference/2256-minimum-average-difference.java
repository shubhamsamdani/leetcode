class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            left[i] = sum;
        }
        
        sum = 0;
        for(int i = n-1; i >= 0; i--){
            sum += nums[i];
            right[i] = sum;
        }
        
        long max = Long.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < n; i++){

            long l = left[i]/(i+1);
            long r;
            if(n-i-1 == 0){
                r = 0;
            } else{
                r = (sum - left[i])/(n-i-1);
            }
            
            
            //System.out.println("i->" + i + ", left->" +l + ", right -> " + r);
            if(Math.abs(l - r) < max){
                index = i;
                max = Math.abs(l - r);
            }
        }
        
        return index;
    }
}