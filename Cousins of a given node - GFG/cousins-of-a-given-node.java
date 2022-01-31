// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    
    public static Node point(Node root, int n)
    {
        if(root == null)
            return null;
            
        if(root.data == n)
            return root;
            
        Node l = point(root.left, n);
        if(l!=null && l.data==n)
            return l;
            
        Node r= point(root.right, n);
        return r;
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            Node root = buildTree(s);
            
            Node p = point(root,n);
            
            Solution ob=new Solution();
            ArrayList<Integer> ans= ob.printCousins(root, p);
            
            for(int i=0;i<ans.size();i++)
            {
                    System.out.print(ans.get(i)+" ");
    
            }
            
            System.out.println();
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
       int level = getLevel(root,node_to_find, 1);
       ArrayList<Integer> res = new ArrayList<Integer>();
       printGivenLevel(root,node_to_find,level,res);
       
       if(res.isEmpty()){
           res.add(-1);
       }
       return res;
    }
    
    private static void printGivenLevel(Node root, Node node_to_find, int level,ArrayList<Integer> res){
        if(root == null || level < 2)
            return;
            
        if(level == 2){
            
            if(root.right == node_to_find || root.left == node_to_find){
                return;
            } else{
                if(root.left != null){
                    res.add(root.left.data);
                }
                
                if(root.right != null){
                    res.add(root.right.data);
                }
                
            }
        } else if(level > 2){
            printGivenLevel(root.left,node_to_find,level-1,res);
            printGivenLevel(root.right,node_to_find,level-1,res);    
        }
    }
    
    private static int getLevel(Node root, Node node_to_find, int level){
        if(root == null){
            return 0;
        }
        
        if(root == node_to_find){
            return level;
        }
        
        int downlevel = getLevel(root.left,node_to_find,level+1);
        if(downlevel != 0){
           return downlevel; 
        }
        
        downlevel = getLevel(root.right,node_to_find,level+1);
        
        return downlevel;
    }
}