

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int w[][] = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j) w[i][j] = 100000;
            }
        }

        for(int i=0;i<edges.length;i++) {
            w[edges[i][0]][edges[i][1]] = edges[i][2];
            w[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int via=0;via<n;via++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                   w[i][j] = Math.min(w[i][j], w[i][via] + w[j][via]);
                }
            }
        }

       
        int ans[] = new int[n];
        for(int city=0;city<n;city++) {
            for(int j=0;j<n;j++) {
                if(w[city][j] <= distanceThreshold) {
                    ans[city]++;
                }
            }
        }

        int city=0;
        int min = ans[city];
        for(int i=0;i<n;i++) {
            if(ans[i]<=min) {
                min = ans[i];
                city=i;
            }
        }

        return city;
    }
}