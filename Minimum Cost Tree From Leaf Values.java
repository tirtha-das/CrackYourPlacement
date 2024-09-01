import java.util.*;

class Solution 
{
    public int getMax(int i,int j,int[] nums)
    {
        int ans=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++)  ans=Math.max(ans,nums[idx]);
        return ans;
    }
    public int fun(int i,int j,int[] nums,int[][] dp)
    {
        if(i==j)  return 0;
        
        if(dp[i][j]!=-1)  return dp[i][j];
        
        int min=Integer.MAX_VALUE;
        
        
        for(int idx=i;idx<j;idx++)
        {
            min=Math.min(min,(getMax(i,idx,nums)*getMax(idx+1,j,nums))+fun(i,idx,nums,dp)+fun(idx+1,j,nums,dp));
        }
        return dp[i][j]=min;
    }
    public int mctFromLeafValues(int[] arr) 
    {
        int[][] dp=new int[arr.length][arr.length];
        for(int[] i : dp) Arrays.fill(i,-1);
        return fun(0,arr.length-1,arr,dp);
    }
}