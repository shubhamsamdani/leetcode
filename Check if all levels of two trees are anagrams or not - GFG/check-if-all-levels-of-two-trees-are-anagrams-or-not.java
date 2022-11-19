//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Node> q1 = new LinkedList<>();
        q1.add(node1);
        
        Queue<Node> q2 = new LinkedList<>();
        q2.add(node2);
        while(!q1.isEmpty() && !q2.isEmpty()){
            int size = q1.size();
            int size2 = q2.size();
            
            if(size != size2){
                return false;
            }
            
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < size; i++){
                Node temp1 = q1.poll();
                map.put(temp1.data,map.getOrDefault(temp1.data,0)+1);
                
                if(temp1.left != null){
                    q1.add(temp1.left);
                }
                
                if(temp1.right != null){
                    q1.add(temp1.right);
                }
            }
            
            for(int i = 0; i < size2; i++){
                Node temp1 = q2.poll();
                map.put(temp1.data,map.getOrDefault(temp1.data,0)-1);
                
                if(temp1.left != null){
                    q2.add(temp1.left);
                }
                
                if(temp1.right != null){
                    q2.add(temp1.right);
                }
            }
            
            if(mapContainsNonZero(map)){
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean mapContainsNonZero(Map<Integer,Integer> map){
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() != 0){
                return true;
            }
        }
        
        return false;
    }
}
        
