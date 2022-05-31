class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= n-k; i++){
            StringBuilder sb = new StringBuilder("");
            for(int j = i; j < i+k && j < n; j++){
                sb.append(s.charAt(j));
            }
            
            set.add(sb.toString());
        }
        
        return set.size() == (Math.pow(2,k));
    }
}