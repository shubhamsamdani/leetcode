class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        
        List<List<String>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> curr, String inputString){
        if(inputString.length() == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < inputString.length(); i++){
            String first = inputString.substring(0, i+1);
            if(isPalindrome(first)){
                curr.add(first);
                String sec = inputString.substring(i+1,inputString.length());
                helper(res,curr,sec);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        String reversedStr = new StringBuilder(s).reverse().toString();
        return s.equals(reversedStr);
    }
}