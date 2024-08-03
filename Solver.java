public class Solver
{
    public boolean solve(int[][] sudoku)
    {
        return solve(sudoku, 0, 0);
    }

    private boolean solve(int[][] sudoku, int row, int col)
    {
        if (row == 9)
            return true;
        int nextCol = col + 1;
        int nextRow = row;
        if (nextCol == 9) {
            nextCol = 0;
            nextRow++;
        }
        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check_if_available(sudoku, i, row, col)) {
                    sudoku[row][col] = i;
                    if (solve(sudoku, nextRow, nextCol))
                        return true;
                }
            }
            sudoku[row][col] = 0;
            return false;
        }
        return solve(sudoku, nextRow, nextCol);
    }
    
    public boolean check_if_available(int[][] sudoku, int n, int row, int col)
    {
        return check_row(sudoku, n, row, col) &&
               check_column(sudoku, n, row, col) &&
               check_box(sudoku, n, row, col);
    }

    private boolean check_row(int[][] sudoku, int n, int row, int col)
    {
        for (int i = 0; i < 9; i++) {
            if (i != col) {
                if (sudoku[row][i] == n)
                    return false;
            }
        }
        return true;
    }

    private boolean check_column(int[][] sudoku, int n, int row, int col)
    {
        for (int i = 0; i < 9; i++) {
            if (i != row) {
                if (sudoku[i][col] == n)
                    return false;
            }
        }
        return true;
    }

    private boolean check_box(int[][]sudoku, int n, int row, int col)
    {
        int first_row = (row / 3) * 3;
        int first_col = (col / 3) * 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[first_row + i][first_col + j] == n)
                    return false;
            }
        }
        return true;
    }

    public void printSudoku(int[][] sudoku)
    {
        System.out.println();
        System.out.printf(
            " %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n",
            sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[0][6], sudoku[0][7], sudoku[0][8],
            sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[1][6], sudoku[1][7], sudoku[1][8],
            sudoku[2][0], sudoku[2][1], sudoku[2][2], sudoku[2][3], sudoku[2][4], sudoku[2][5], sudoku[2][6], sudoku[2][7], sudoku[2][8]);
        System.out.println("-------+-------+-------");
        System.out.printf(
            " %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n",
            sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[3][6], sudoku[3][7], sudoku[3][8],
            sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[4][6], sudoku[4][7], sudoku[4][8],
            sudoku[5][0], sudoku[5][1], sudoku[5][2], sudoku[5][3], sudoku[5][4], sudoku[5][5], sudoku[5][6], sudoku[5][7], sudoku[5][8]);
        System.out.println("-------+-------+-------");
        System.out.printf(
            " %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n %d %d %d | %d %d %d | %d %d %d \n",
            sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[6][6], sudoku[6][7], sudoku[6][8],
            sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[7][6], sudoku[7][7], sudoku[7][8],
            sudoku[8][0], sudoku[8][1], sudoku[8][2], sudoku[8][3], sudoku[8][4], sudoku[8][5], sudoku[8][6], sudoku[8][7], sudoku[8][8]);
        System.out.println();
    }
}
