import java.util.*;


class Solution {
    int m,n;
    int dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        this.m=m;
        this.n=n;
        return helper(0, 0, 0, strs);
    }   

    int helper(int index, int totalCountZeros, int totalCountOnes, String [] strs){
        if(index>=strs.length) return 0;
        if(totalCountZeros>m || totalCountOnes>n) return 0;
        if(dp[index][totalCountZeros][totalCountOnes]!=-1) return dp[index][totalCountZeros][totalCountOnes];
        
        int countOfZero=0, countOfOne=0;

        for(Character c:strs[index].toCharArray()){
            if(c=='0') countOfZero++;
            else countOfOne++;
        }
        int answer=0;

        if(totalCountZeros+countOfZero>m || totalCountOnes+countOfOne>n){
            answer=helper(index+1, totalCountZeros, totalCountOnes, strs);
        }else{
            answer = Math.max(helper(index+1, totalCountZeros, totalCountOnes, strs), 
            1+helper(index+1, totalCountZeros+countOfZero, totalCountOnes+countOfOne, strs));
        }

        dp[index][totalCountZeros][totalCountOnes]=answer;
        return dp[index][totalCountZeros][totalCountOnes];   
    }

}