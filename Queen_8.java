
public class Queen_8 {

    private static final int BOARD_SIZE = 8;
    private static final char EMPTY = '-';
    private static final char QUEEN = 'Q';

    private char[][] board;

    public Queen_8() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void solve() {
        placeQueens(0);
        printBoard();
    }


    private boolean placeQueens(int col) {

        if (col >= BOARD_SIZE) {
            return true; // All queens have been successfully placed
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafe(row, col)) {
                board[row][col] = QUEEN;

                if (placeQueens(col + 1)) {
                    return true;
                }

                board[row][col] = EMPTY; // Backtracking
            }
        }

        return false; // Failed to place queens in the current column
    }

    private boolean isSafe(int row, int col) {

        // Check row and column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == QUEEN || board[i][col] == QUEEN) {
                return false;
            }
        }

        // Check diagonals
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == QUEEN) {
                return false;
            }
        }

        for (int i = row, j = col; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (board[i][j] == QUEEN) {
                return false;
            }
        }

        return true;
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        Queen_8 queens = new Queen_8();
        queens.solve();
    }
}
