// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
            int A[] = new int[26];
    char arr1[] = s.toCharArray();
    char arr2[] = s1.toCharArray();
    
    int res = 0;
    int n = s.length();
    int m = s1.length();
    
    int i = 0, j = 0;
    while(i < n || j < m){
        
        if(i < n){
            A[arr1[i] - 'a']++ ;
            i++ ;    
        }
        
        if(j < m){
            A[arr2[j] - 'a']-- ;
            j++ ;    
        }
        
    }
    
    for(i = 0; i < 26; i++){
        if(A[i] != 0){
            res += Math.abs(A[i]);
        }
    }
    
    return res;
        }
}