class Solution {
    int[] root = new int[1000]; //value is index
    int result = 0;
 
    public int removeStones(int[][] stones) {
        result = stones.length;
        for(int i=0; i<stones.length; i++){
            root[i]=i;    
        }
 
        for(int i=0; i<stones.length; i++){
            for(int j=i+1; j<stones.length; j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i, j);
                }
            }
        }
 
        return stones.length-result;
    }
 
    public void union(int i, int j){
        int ri = getRoot(i);
        int rj = getRoot(j);
 
        if(ri==rj){
            return;
        }
 
        root[getRoot(i)]=getRoot(j);
        result--;
    }
 
    public int getRoot(int i){
        while(i!=root[i]){
            i=root[i];
        }
 
        return i;
    }
}