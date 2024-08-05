import java.util.*;

class Solution {
    static int lad;
 public int furthestBuilding(int[] heights, int bricks, int ladders) {
         int res=0;
         lad = ladders;
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
         int current = heights[0];
         long sum = 0;
         for(int i=1; i<heights.length; i++){
             if(current<heights[i]){
                 int diff = heights[i] - current;
                 sum = sum+ diff;
                 pq.add(diff);
                 if(sum>bricks){
                     sum = useLadder(sum, pq);
                     if(sum>bricks)
                         break;
                 }
             }
             current = heights[i];
             res++;
         }
         return res;
     }
     
     private long useLadder(long sum, PriorityQueue<Integer> pq) {
         if(lad>0){
             sum = sum - pq.poll();
             lad--;
         }
         return sum;
     }
 }