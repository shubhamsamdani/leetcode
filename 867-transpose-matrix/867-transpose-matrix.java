class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] res = new int[m][n];
        int i, j;
        for (i = 0; i < n; i++)
            for (j = 0; j < m; j++)
                res[j][i] = matrix[i][j];
        
        
        return res;
    }
}