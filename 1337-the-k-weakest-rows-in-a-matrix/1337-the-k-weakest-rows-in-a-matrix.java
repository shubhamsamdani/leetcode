class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    break;
                }
                count++ ;
            }
            mat[i][0] = count;
            mat[i][m-1] = i;
        }
        
        Arrays.sort(mat,(a,b) -> (a[0] - b[0]));
        int res[] = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = mat[i][m-1];
        }
        
        return res;
    }
}