class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int res = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            res *= 26;
            res += ((int)(arr[i] - 'A') + 1);
        }
        
        return res;
    }
}