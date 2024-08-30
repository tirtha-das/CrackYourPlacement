import java.util.*;
class Solution {

    class UnionFind {

        private int[] node;
        private int[] size;
        private int numComponents;
        private int maxSize = Integer.MIN_VALUE;;

        UnionFind(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            this.node = new int[rows * cols];
            this.size = new int[rows * cols];
            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    if(grid[row][col] == 1) {
                        this.node[row * cols + col] = row * cols + col;
                        this.size[row * cols + col] = 1;
                        this.numComponents++;
                    }   
                }
            }
        }

        public int getSize(int a, List<Integer> list) {
            int size = 1;
            Set<Integer> set = new HashSet<>();
            for(int b : list) {
                int rootB = root(b);
                if(!set.contains(rootB)){
                    size = size + this.size[rootB];
                } 
                set.add(rootB);
            }
            return size;
        }

        public int getMaxSize() {
            return this.maxSize;
        }

        public boolean union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);

            if(rootA == rootB) return false;

            if(this.size[rootA] < this.size[rootB]) {
                this.node[rootA] = rootB;
                this.size[rootB] = this.size[rootB] + this.size[rootA];
                this.maxSize = Math.max(maxSize, this.size[rootB]);
            } else {
                this.node[rootB] = rootA;
                this.size[rootA] = this.size[rootA] + this.size[rootB];
                this.maxSize = Math.max(maxSize, this.size[rootA]);
            }
            
            this.numComponents--;
            return true;
        }

        public boolean isConnected(int a, int b) {
            return root(a) == root(b);
        }

        public int totalComponents() {
            return this.numComponents;
        }

        private int root(int a) {
            int root = a;
            while(this.node[root] != root) {
                root = node[root];
            }

            while(this.node[a] != a) {
                a = node[a];
                node[a] = root;
            }
            return root;
        }
    }
 
    public int largestIsland(int[][] grid) {
        if(grid.length == 1) return 1;
        
        UnionFind uf = new UnionFind(grid);

        int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int rows = grid.length, cols = grid[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    grid[row][col] = -1;
                    for(int[] move : moves) {
                        int nRow = row + move[0];
                        int nCol = col + move[1];
                        if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
                            uf.union((row * cols + col), (nRow * cols + nCol));
                        }
                    }
                }   
            }
        }

        List<Integer> cells = new ArrayList<>();
        int maxSize = uf.getMaxSize();
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {
                    grid[row][col] = -2;
                    for(int[] move : moves) {
                        int nRow = row + move[0];
                        int nCol = col + move[1];
                        if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == -1) {
                            cells.add((nRow * cols) + nCol);
                        }
                    }
                    int size = uf.getSize(((row * cols) + col), cells);
                    maxSize = Math.max(maxSize, size);
                    cells.clear();
                }   
            }
        }
        return maxSize;
    }
}