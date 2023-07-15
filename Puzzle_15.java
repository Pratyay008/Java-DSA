import java.util.Arrays;

public class Puzzle_15 {

    private static final int SIZE = 4;
    private static final int[][] GOAL_STATE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    private int[][] board;

    public Puzzle_15(int[][] initial) {
        board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = initial[i][j];
            }
        }
    }

    public boolean isGoalState() {
        return Arrays.deepEquals(board, GOAL_STATE);
    }

    public boolean move(int tile) {
        int row = 0, col = 0;
        boolean found = false;

        for (row = 0; row < SIZE; row++) {
            for (col = 0; col < SIZE; col++) {
                if (board[row][col] == tile) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (row > 0 && board[row - 1][col] == 0) {
            board[row - 1][col] = tile;
            board[row][col] = 0;
            return true;

        } else if (row < SIZE - 1 && board[row + 1][col] == 0) {
            board[row + 1][col] = tile;
            board[row][col] = 0;
            return true;

        } else if (col > 0 && board[row][col - 1] == 0) {
            board[row][col - 1] = tile;
            board[row][col] = 0;
            return true;

        } else if (col < SIZE - 1 && board[row][col + 1] == 0) {
            board[row][col + 1] = tile;
            board[row][col] = 0;
            return true;
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] initial = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 0, 15}};
        
        Puzzle_15 puzzle = new Puzzle_15(initial);

        System.out.println("Initial board:");
        puzzle.printBoard();

        if (puzzle.isGoalState()) {
            System.out.println("Already at the goal state.");
        } 
        else {
            System.out.println("Moving tile 15...");
            puzzle.move(15);
            puzzle.printBoard();

            if (puzzle.isGoalState()) {
                System.out.println("Reached the goal state!");
            } else {
                System.out.println("Not at the goal state yet.");
            }
        }
    }
}
