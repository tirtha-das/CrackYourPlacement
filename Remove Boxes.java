class Solution {
   
    int dp[][][];
    public int removeBoxes(int[] boxes) {
     
      int n = boxes.length;
      dp= new int[n+1][n+1][n+1];
      return get(boxes, 0, boxes.length-1, 0);
      
    }

    public int get(int [] boxes, int i , int j, int streak)
    {
       if(i>j)
        return 0;
       
      
      
        
      while(i+1<=j && boxes[i]== boxes[i+1])
      {
         i++;
         streak++;
      }

     
      if(dp[i][j][streak]>0)
       return dp[i][j][streak];
         
 
      int ans = (streak+1) * (streak+1) + get(boxes,i+1,j,0);

      for(int k=i+1;k<=j;k++)
      {

          if(boxes[i]== boxes[k])
          {
              ans = Math.max(ans,get(boxes,i+1,k-1,0) + get(boxes,k, j, streak+1 ));
          }
      }

      return dp[i][j][streak]=ans;
       
    }

    
}