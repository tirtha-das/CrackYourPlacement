class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
     boolean solve(char[][] board, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        
        if (row == 9) {
            return true;
        }
        
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }
        
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
     boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
            if (board[i][col] == c) {
                return false;
            }
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;
            if (board[boxRow][boxCol] == c) {
                return false;
            }
        }
        return true;
    }
}