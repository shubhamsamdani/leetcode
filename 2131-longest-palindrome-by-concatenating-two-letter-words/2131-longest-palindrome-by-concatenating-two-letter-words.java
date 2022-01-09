class Solution {
    public int longestPalindrome(String[] words) {
        int len = 0;
        Map<String,Integer> diff = new HashMap<>();
        Set<String> same = new HashSet<>();
        for(String word : words){
            char c1 = word.charAt(0), c2 = word.charAt(1);
            if(c1 != c2){
                String rev = "" + c2  + c1;
                int cnt = diff.getOrDefault(rev,0);
                if(cnt > 0){
                    len += 4;
                    diff.put(rev, cnt-1);
                } else{
                    diff.put(word, diff.getOrDefault(word,0) + 1);
                }
            } else{
                if(same.contains(word)){
                    len += 4;
                    same.remove(word);
                } else{
                    same.add(word);
                }
            }
        }
        
        if(same.size() > 0){
            len += 2;
        }
        
        return len;
    }
}