class Solution {
    public long getCount(int n) {
        
        
        long dp[][][] = new long[4][3][n+1];
        
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        long ans = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(i==3 && j==0 || i==3 && j==2) continue;
                
                ans += helper(i,j,n,dp);
            }
        }
        
        return ans;
    }
    
    long helper(int i,int j,int n, long dp[][][]){
        if(i<0 || j<0 ||i>3 || j>2) return 0;
         if(i==3 && j==0 || i==3 && j==2) return 0;
         if(n==1) return 1;
         if(dp[i][j][n]!=-1) return dp[i][j][n];
         
         n--;
         
         return dp[i][j][n+1] =  helper(i-1,j,n,dp) + helper(i,j-1,n,dp) + helper(i+1,j,n,dp) + helper(i,j+1,n,dp) + helper(i,j,n,dp);
        
    }
    
}