class Solution {
    int emptyCnt, currCnt, ans;
    boolean[][] visited;
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        emptyCnt = currCnt = ans = 0;
        int r = 0, c = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                if(grid[i][j] == 0) emptyCnt++;
            }
        }

        visited = new boolean[rows][cols];
        dfs(grid, r, c);

        return ans;
    }

    void dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col] || grid[row][col] == -1) return;
        if(grid[row][col] == 2){
            if(emptyCnt == currCnt) ans++;
            return;
        }

        visited[row][col] = true;
        if(grid[row][col] == 0) currCnt++;
        
        for(int[] d: dir)
            dfs(grid, row + d[0], col + d[1]);

        if(grid[row][col] == 0) currCnt--;
        visited[row][col] = false;
    }
}