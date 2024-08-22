import java.util.*;

class Solution {
    int solve(int low, int high,int[]cows,int noOfCow){
       if(low>high) return 1;

       int mid = ((high-low)/2)+low;

       int first = cows[0];
       int cnt = noOfCow;
       for(int i=1;i<cows.length;i++){
           if(cows[i]-first>=mid){
               noOfCow--;
               if(noOfCow==0) break;

               first = cows[i];
           }
       }

       if(noOfCow==0){
          return Math.max(mid,solve(mid+1,high,cows,cnt));
       }else return solve(low,mid-1,cows,cnt);

   }

   public int maxDistance(int[] position, int m) {
       int n=position.length;
       Arrays.sort(position);
 
     return solve(1,position[n-1]-position[0],position,m-1);
   }
}