//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        Stack<Long> s1 = new Stack<>();
        long[] res = new long[n];
        
        for(int i = n-1; i >= 0; i--){
            if(s1.isEmpty()){
                s1.push(arr[i]);
                res[i] = -1;
            } else{
                while(!s1.isEmpty() && s1.peek() < arr[i]){
                    s1.pop();
                }
                
                if(!s1.isEmpty())
                    res[i] = s1.peek();
                else
                    res[i] = -1;
                    
                s1.push(arr[i]);
            }
        }
        
        return res;
    } 
}