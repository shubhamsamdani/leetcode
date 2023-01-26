//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        char[] arr = str.toCharArray();
        int[] upper = new int[26];
        int[] lower = new int[26];
        
        int upperSize = 0;
        int lowerSize = 0;
        for(char c : arr){
            if(c >= 'A' && c <= 'Z'){
                upper[c - 'A']++ ;
                upperSize++ ;
            } else{
                lower[c - 'a']++ ;
                lowerSize++ ;
            }
        }
        
        char[] upperc = new char[upperSize];
        char[] lowerc = new char[lowerSize];
        
        int index = 0;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < upper[i]; j++){
                upperc[index] = (char)('A' + i);
                index++ ;
            }
        }
        
        index = 0;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < lower[i]; j++){
                lowerc[index] = (char)('a' + i);
                index++ ;
            }
        }
        
        int k = 0;
        int i = 0;
        int j = 0;
        
        
        while(k < str.length()){
            if(arr[k] >= 'A' && arr[k] <= 'Z'){
                arr[k] = upperc[i];
                i++ ;
            } else{
                arr[k] = lowerc[j];
                j++ ;
            }
            
            k++ ;
        }
        
        return new String(arr);
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends