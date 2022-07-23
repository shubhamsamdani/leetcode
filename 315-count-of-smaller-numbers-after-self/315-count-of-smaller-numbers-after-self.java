class Solution {
    
    class SegmentTree {
        int start, end;
        int sum;
        SegmentTree left, right;
        
        public SegmentTree(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
        
    }
    
    SegmentTree buildTree(int start, int end){
        SegmentTree node = new SegmentTree(start,end);
        
        if(start == end){
            return node;
        }
        
        int mid = start + (end-start)/2 ;
        SegmentTree left = buildTree(start,mid);
        SegmentTree right = buildTree(mid+1,end);
        
        node.left = left;
        node.right = right;
        
        return node;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        int[] count = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int num : nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        
        
        SegmentTree root = buildTree(min,max);
        
        for(int i = nums.length - 1; i >= 0; i--){
            update(root,nums[i]);
            count[i] = sumRange(root,min,nums[i]-1);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int cnt : count){
            res.add(cnt);
        }
        
        return res;
    }
    
    int sumRange(SegmentTree node, int start, int end){
        if(node == null || start > end){
            return 0;
        }
        
        if(node.start == start && node.end == end){
            return node.sum;
        }
        
        int mid = node.start + (node.end - node.start)/2 ;
        if(end <= mid){
            return sumRange(node.left,start,end);
        } else if(start > mid){
            return sumRange(node.right, start, end);
        } else{
            return sumRange(node.left,start,mid) + sumRange(node.right, mid+1, end);
        }
    }
    
    void update(SegmentTree root, int val){
        if(root == null){
            return;
        }
        
        if(root.start == val && root.end == val){
            root.sum += 1;
            return;
        }
        
        int mid = root.start + (root.end - root.start)/2 ;
        if(val <= mid){
            update(root.left,val);
        } else{
            update(root.right,val);
        }
        
        root.sum = root.left.sum + root.right.sum ;
    }
    
    
}