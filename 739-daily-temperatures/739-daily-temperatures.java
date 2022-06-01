class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1] = 0;
        
        Stack<Integer> s1 = new Stack<>();
        for( int i = 0; i < n; i++){
            while(!s1.isEmpty() && temperatures[s1.peek()] < temperatures[i]){
                int index = s1.pop();
                res[index] = i-index ;
            }
            
            s1.push(i);
        }
        
        return res;
    }
}