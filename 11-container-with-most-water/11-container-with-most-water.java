class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int h = height.length - 1;
        while(l < h){
            int area = (h-l)*(Math.min(height[l],height[h]));
            max = Math.max(max,area);
            if(height[h] < height[l]){
                h-- ;
            } else{
                l++ ;
            }
        }
        
        return max;
    }
}