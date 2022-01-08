class NumMatrix {

    int[][] t;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        t = new int[row+1][col+1];
        
        for(int i = 0; i <= row; i++){
            t[i][0] = 0;
        }
        
        for(int i = 0; i <= col; i++){
            t[0][i] = 0;
        }
        
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                t[i][j] = matrix[i-1][j-1] + t[i-1][j] + t[i][j-1] - t[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = t[row2+1][col2+1] - t[row1][col2+1] - t[row2+1][col1] + t[row1][col1];
        return val;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */