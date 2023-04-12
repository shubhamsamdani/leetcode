class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        
        StringBuilder sb = new StringBuilder("");
        Stack<String> s1 = new Stack<>();
        String res = "";
        for(String s : strs){
            if(!s.isEmpty()){
                
                if(s.equals("..")){
                    
                    if(!s1.isEmpty())
                        s1.pop();
                    continue;
                }
                
                if(s.equals(".")){
                    continue;
                }
                
                s1.push(s);
            }
        }
        
        while(!s1.isEmpty()){
            res = "/" + s1.pop() + res;
        }
        
        if(res.isEmpty()){
            res = "/";
        }
        
        return res;
    }
}