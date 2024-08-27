import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int []> que = new LinkedList<>();
        int[][] visited = new int[n][n];
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = grid[i][j];
                if(grid[i][j] == 1){
                    que.offer(new int[]{i, j});
                }
            }
        }
        if((que.size() == 0) || (que.size() == n*n)){
            return -1;
        }
        int res = -1;
        while(!que.isEmpty()){
            int sz = que.size();
            while(sz -- > 0){
                int[] curr = que.poll();
                int i = curr[0], j = curr[1];
                for(int[] d: dir){
                    int x = i + d[0], y = j + d[1];
                    if(x >= 0 && y >= 0 && x < n && y < n && visited[x][y] == 0){
                        visited[x][y] = 1;
                        que.offer(new int[]{x, y});
                    }
                }
            }
            res++;
        }
        return res == 0?-1:res;
    }
}