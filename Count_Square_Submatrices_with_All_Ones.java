class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length,n= matrix[0].length;

        int[][]dp = new int[m][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];

            if(dp[0][i]==1) ans++;
        }

        for(int i=1;i<m;i++){
            dp[i][0] = matrix[i][0];

            if(dp[i][0]==1) ans++;
        }


        for(int row = 1;row<m;row++){
            for(int col = 1;col<n;col++){
                if(matrix[row][col]==1){
                dp[row][col] = Math.min(dp[row][col-1],Math.min(dp[row-1][col],dp[row-1][col-1]))+1;
                ans+=dp[row][col];
                }
                else dp[row][col] = 0;
               
            }
        }

        

        return ans;
    }
}