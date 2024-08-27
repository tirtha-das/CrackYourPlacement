class NumMatrix {

    int[][] matrix;
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n][m];
        prefixSum[0][0] = matrix[0][0];
        for(int col=1;col<m;col++){
            prefixSum[0][col] = prefixSum[0][col-1]+matrix[0][col];
        }
        for(int row =1;row<n;row++){
            prefixSum[row][0] = prefixSum[row-1][0]+matrix[row][0];
        }

        for(int row=1;row<n;row++){
            for(int col=1;col<m;col++){
                prefixSum[row][col] = prefixSum[row-1][col]+prefixSum[row][col-1] - prefixSum[row-1][col-1] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefixSum[row2][col2];
        if((row1-1)>=0){
            sum = sum - prefixSum[row1-1][col2];
        }
        if((col1-1)>=0){
            sum = sum - prefixSum[row2][col1-1];
        }
        if((row1-1)>=0 && (col1-1)>=0){
            sum = sum + prefixSum[row1-1][col1-1];
        }
        return sum;
    }
}

