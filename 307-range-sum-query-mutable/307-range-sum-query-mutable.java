class NumArray {
    
    class SegmentTree{
        SegmentTree left;
        SegmentTree right;
        int sum;
        int start;
        int end;
        
        public SegmentTree(int start, int end){
            this.left = null;
            this.right = null;
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
        
    }
    
    SegmentTree buildTree(int[] nums, int start, int end){
        
        SegmentTree tree = new SegmentTree(start,end);
        
        if(start > end){
            return null;
        }
        
        if(start == end){
            tree.sum = nums[start];
            return tree;
        }
        
        int mid = start + (end - start)/2 ;
        tree.left = buildTree(nums, start, mid);
        tree.right = buildTree(nums,mid+1,end);
        tree.sum = tree.left.sum + tree.right.sum;
        
        return tree;
    }
    
    SegmentTree root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    void updateHelper(SegmentTree root, int index, int val){
        if(root.start == index && root.end == index){
            root.sum = val;
        } else{
            int mid = root.start + (root.end - root.start)/2 ;
        if(mid  >= index){
            updateHelper(root.left,index,val);
        } else{
            updateHelper(root.right,index,val);
        }
        
        root.sum = root.left.sum + root.right.sum;
        }
        
        
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root,left,right);
    }
    
    int sumRangeHelper(SegmentTree root, int left, int right){
        if(left > right){
            return 0;
        }
        
        if(root.start == left && root.end == right){
            return root.sum;
        } else{
            int mid = root.start + (root.end - root.start)/2 ;  
            if(mid >= right){
                return sumRangeHelper(root.left,left,right);
            } else if(mid+2 <= left){
                return sumRangeHelper(root.right,left,right);
            } else{
                return sumRangeHelper(root.left,left,mid) + sumRangeHelper(root.right,mid+1,right);
            }
        }
        
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */