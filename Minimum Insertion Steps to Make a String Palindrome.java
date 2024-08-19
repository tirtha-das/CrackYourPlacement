import java.util.*;

class Solution {
    public int minInsertions(String s) {
        int n= s.length();
        int[][] dp= new int[n+1][n+1];
        for(int[] temp: dp){
            Arrays.fill(temp, -1);
        }
        return getCount(s, 0, n-1, dp);
    }

    public int getCount(String s, int left, int right, int[][] dp){
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        if(left == right){
            return 0;
        }
        if(left+1 == right){
            if(s.charAt(left) == s.charAt(right)){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        if(s.charAt(left) == s.charAt(right)){
            int ans= getCount(s, left+1, right-1, dp);
            dp[left][right]= ans;
            return ans;
        }
        else{
            int ans1= getCount(s, left, right-1, dp);
            int ans2= getCount(s, left+1, right, dp);
            dp[left][right]= Math.min(ans1, ans2)+1;
            return Math.min(ans1, ans2)+1;
        }
    }
}