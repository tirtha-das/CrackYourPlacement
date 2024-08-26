class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int w8 = edges[i][2];

            dist[from][to] = w8;
            dist[to][from] = w8;
        }

        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int count=Integer.MAX_VALUE;
        int city=-1;
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
               if(dist[i][j]<=threshold){
                cnt++;
               }
            }
            if(cnt <= count){
                city = i;
                count=cnt;
            }
        }
        return city;
    }
}