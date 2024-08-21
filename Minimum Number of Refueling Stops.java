import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int currentcoordinates = startFuel;
        int noOfStopsNeeded = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int[] station : stations){
            int nextCoordinates = station[0];
            int nextFuel = station[1];
            
            while(currentcoordinates < nextCoordinates){
                if(pq.isEmpty()){
                    return -1;
                }
                int maxFuel = pq.poll();
                currentcoordinates += maxFuel;
                noOfStopsNeeded++;   
            }
            pq.offer(nextFuel);
        }
        
        while(currentcoordinates < target){
            if(pq.isEmpty()){
                return -1;
            }
            int maxFule = pq.poll();
            currentcoordinates += maxFule;
            noOfStopsNeeded++;
        }
        
        return noOfStopsNeeded;
    }
}