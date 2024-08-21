class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] t=new int[n+1][m+1];
        int max=0;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=t[i-1][j-1]+1;
                    max=Math.max(t[i][j],max);
                }else{
                    t[i][j]=0;
                }
            }
        }
        return max;
    }
}