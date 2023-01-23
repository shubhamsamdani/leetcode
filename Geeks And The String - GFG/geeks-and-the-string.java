//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        Stack<Character> s1 = new Stack<>();
        for(char c : arr){
            if(s1.isEmpty()){
                s1.push(c);
            } else{
                if(!s1.isEmpty() && s1.peek() == c){
                    s1.pop();
                }else{
                    s1.push(c);    
                }
            }
        }
        
        if(s1.isEmpty()){
            return "-1";
        }
        
        for(char c : s1){
            sb.append(c);
        }
        
        return sb.toString();
    }
}
        
