import java.util.*;


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }

        for(int f[]:flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,src,0});

        while(!q.isEmpty()){
            int a[]=q.poll();
            int stop=a[0];
            int city=a[1];
            int d=a[2];
            if(stop>k) continue;
            for(int e[]:adj.get(city)){
                if(d+e[1]<dist[e[0]]&& stop<=k){
                    dist[e[0]]=d+e[1];
                    q.offer(new int[]{stop+1,e[0],dist[e[0]]});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}