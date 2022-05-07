class Solution {
    public boolean find132pattern(int[] nums) {
        boolean res = false;
        int secMax = Integer.MIN_VALUE;
        Stack<Integer> s1 = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] < secMax) return true;
            
            while(!s1.isEmpty() && nums[i] > s1.peek()){
                secMax = Math.max(secMax,s1.pop());
            }
            
            s1.push(nums[i]);
        }
        
        return false;
    }
}