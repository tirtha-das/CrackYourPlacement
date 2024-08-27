import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); 
        boolean[] visited = new boolean[len * len + 1];
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.poll();
                if (cur == len * len) {
                    return moves;
                }
                for (int k = 1; k < 7; k++) {
                    if (k + cur > len * len) break;
                    int nextSqaure = cur + k;
                    if (!visited[nextSqaure]) {
                        visited[nextSqaure] = true;
                        int[] pos = intToPos(nextSqaure, len);
                        if (board[pos[0]][pos[1]] != -1) {
                            nextSqaure = board[pos[0]][pos[1]]; //we jump 
                        }
                        q.offer(nextSqaure);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

     int[] intToPos(int square, int n) {
        int row = n - (square - 1) / n - 1;
        int col = ((n - row) % 2 != 0) ? (square - 1) % n : n - (square - 1) % n - 1;
        return new int[] {row, col};
    }
}