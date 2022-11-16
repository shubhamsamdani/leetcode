//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int count = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                count += getCount(arr,i,j);
            }
        }
        
        return count;
    }
    
    private static int getCount(char[] arr, int start, int end){
        int[] freq = new int[26];
        for(int i = start; i <= end; i++){
            freq[arr[i] - 'a']++ ;
        }
        
        int max = 0, min = end-start+1;
        for(int i = 0; i < 26; i++){
            max = Math.max(max,freq[i]);
            
            if(freq[i] != 0){
                min = Math.min(min, freq[i]);
            }
            
        }
        
        return max-min;
    }
}
        
