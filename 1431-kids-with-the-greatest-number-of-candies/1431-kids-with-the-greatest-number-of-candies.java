class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        long max = 0;
        for(int el : candies){
            max = Math.max(max, el);
        }
        
        for(int i = 0; i < candies.length; i++){
            boolean flag = false;
            if(candies[i] + extraCandies >= max){
                flag = true;
            }
            
            res.add(flag);
        }
        
        return res;
    }
}