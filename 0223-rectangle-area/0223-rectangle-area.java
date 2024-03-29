class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        if(bx1 >= ax2 || bx2 <= ax1 || by1 >= ay2 || by2 <= ay1) {
            return area1 + area2;
        }

        int maxCommonX = Math.max(ax1, bx1);
        int maxCommonY = Math.max(ay1, by1);

        int minCommonX = Math.min(ax2, bx2);
        int minCommonY = Math.min(ay2, by2);

        return area1 + area2 - (minCommonX - maxCommonX) * (minCommonY - maxCommonY);
    }
}