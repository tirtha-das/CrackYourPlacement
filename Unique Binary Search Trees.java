class Solution {
    public int numTrees(int n) {
        
        long[] dp=new long[n+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return (int)dp[n];
    }
}