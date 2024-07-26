public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        
        visited[i][j] = true;
        
        boolean found = backtrack(board, word, i + 1, j, k + 1, visited) ||
                        backtrack(board, word, i - 1, j, k + 1, visited) ||
                        backtrack(board, word, i, j + 1, k + 1, visited) ||
                        backtrack(board, word, i, j - 1, k + 1, visited);
        
        visited[i][j] = false;
        
        return found;
    }
}