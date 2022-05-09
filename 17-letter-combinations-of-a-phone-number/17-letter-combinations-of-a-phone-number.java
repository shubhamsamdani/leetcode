class Solution {
    public List<String> letterCombinations(String digits) {
       String sets[] = new String[10];
        sets[2] = "abc";
        sets[3] = "def";
        sets[4] = "ghi";
        sets[5] = "jkl";
        sets[6] = "mno";
        sets[7] = "pqrs";
        sets[8] = "tuv";
        sets[9] = "wxyz";
        
        if(digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        
        List<String> ans = new ArrayList<>();
        
        helper(ans,digits,sets,0,"");
        
        return ans;
    }
    
    private void helper(List<String> ans, String digits, String[] sets, int idx, String curr){
        if(idx == digits.length()){
            ans.add(curr);
            return;
        }
        
        String possible = sets[digits.charAt(idx) - '0'];
        for(char c : possible.toCharArray()){
            //curr += c;
            helper(ans,digits,sets,idx+1,curr + c);
            //curr = curr.substring(0,curr.length()-1);
        }
    }
}