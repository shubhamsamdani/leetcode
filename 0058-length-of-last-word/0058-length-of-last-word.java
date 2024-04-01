class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] list = s.split(" ");
        int len = list.length;
        
        return list[len-1].length();
    }
}