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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getListNode(root1);
        List<Integer> list2 = getListNode(root2);
        
        if(list1.isEmpty()){
            return list2 ;
        }
        
        if(list2.isEmpty()){
            return list1;
        }
        
        List<Integer> res = new ArrayList<>();
        int n = list1.size();
        int m = list2.size();
        int i = 0, j = 0;
        while(i < n && j < m){
            if(list1.get(i) <= list2.get(j)){
                res.add(list1.get(i));
                i++ ;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        
        while(i < n){
            res.add(list1.get(i));
            i++ ;
        }
        
        while(j < m){
            res.add(list2.get(j));
            j++ ;
        }
        
        return res;
    }
    
    List<Integer> getListNode(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> q = new Stack<>();
        TreeNode curr = root;
        //q.push(curr);
        while(curr != null || !q.isEmpty()){
            while(curr != null){
                q.push(curr);
                curr = curr.left;
            }
            
            curr = q.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        
        return res;
    }
    
}