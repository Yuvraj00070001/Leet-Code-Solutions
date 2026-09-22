class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word,
                              int row, int col, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current cell doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore 4 directions
        boolean found =
                backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1);

        // Backtrack: restore the cell
        board[row][col] = temp;

        return found;
    }
}