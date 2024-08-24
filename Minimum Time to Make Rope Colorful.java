class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int i=0;
        int j=1;
        int res = 0;
        while(i<n && j<n){
            if(colors.charAt(i) == colors.charAt(j)){
                if(neededTime[i] <= neededTime[j]){
                    res+=neededTime[i];
                    i=j;j++;
                }
                else{
                    res+=neededTime[j];
                    j++;
                }
            }
            else{
                i=j;j++;
            }
        }
        return res;
    }
}