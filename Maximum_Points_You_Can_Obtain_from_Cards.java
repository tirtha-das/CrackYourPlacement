
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum=0;
        for(int i=0;i<k;i++)
			totalSum+=cardPoints[i];
        
        if(k==cardPoints.length)
            return totalSum;
        
        int max=totalSum;
        for(int i=k-1,j=cardPoints.length-1;i>=0;i--,j--){ 
            totalSum += cardPoints[j] - cardPoints[i];
            max = Math.max(max,totalSum);
        }
        return max;
    }
}