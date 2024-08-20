class Solution {

    public int swimInWater(int[][] grid) {
        int minTime = grid[0][0];
        int maxTime = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                maxTime = Math.max(maxTime, grid[i][j]);
            }
        }

        while(minTime <= maxTime) {
            int midTime = minTime + (maxTime - minTime)/2;
            boolean[][] seen = new boolean[grid.length][grid[0].length];
            if(dfs(0, 0, grid, seen, midTime)) {
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }
        return minTime;
    }

     boolean dfs(int y, int x, int[][] grid, boolean[][] seen, int time) {
        if( x == grid[0].length - 1 && y == grid.length - 1) {
            return true;
        }
        int[][] directions = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for(int[] d : directions) {
            int newY = y + d[0];
            int newX = x + d[1];
            if(isValidDirection(newY, newX, grid) && !seen[newY][newX] && grid[newY][newX] <= time) {
                seen[newY][newX] = true;
                if(dfs(newY, newX, grid, seen, time)) {
                    return true;
                }
            }
        }
        return false;
    }

   boolean isValidDirection(int y, int x, int[][] grid) {
        if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length) return true;
        return false;
    }
}