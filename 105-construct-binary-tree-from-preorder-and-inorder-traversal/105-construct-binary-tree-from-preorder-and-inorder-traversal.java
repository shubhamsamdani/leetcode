/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findTree(preorder,inorder,0,preorder.length-1);
    }
    
    TreeNode findTree(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if(start == end){
            return node;
        }
        
        int index = findIndex(inorder,start, end, node.val);
        node.left = findTree(preorder,inorder,start,index-1);
        node.right = findTree(preorder,inorder,index+1,end);
        
        return node;
    }
    
    int findIndex(int[] inorder, int start, int end, int val){
        for(int i = start; i <= end; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        
        return -1;
    }
}