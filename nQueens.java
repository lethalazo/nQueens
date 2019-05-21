import java.util.Arrays;

public class nQueens{
    public static void main(String[] args) {
        nQueens nQueens = new nQueens();
        int n = 2;
        //make an nxn chess board
        int[][] board = new int[n][n];
        //method to check if this board can have placement of n queens that don't threaten each other.
        if(nQueens.placeQueens(0, 0, n, board)){
            System.out.println("Can place "+n+" Queens!");
            //Print the board if satisfied.
            nQueens.printMatrix(board);
        }
        else System.err.println("Can't place "+n+" Queens.");
    }

    private boolean placeQueens(int col, int row, int n, int[][] board){
        //try placing queen in each place and check for outcome
        for(int i = col; i < n; i++){
            board[row][i] = 1;
            //if position is valid
            if(boardValidates(board, i, row, n)){
                //if last row
                if(row == n-1) return true;
                //the current placement leads to a result
                else if(row < n && placeQueens(0, row+1, n, board)) return true;
                //this position does not lead to a result, move to next column
                else board[row][i] = 0;
            }
            else{
                //if this position is not valid, move to next position
                board[row][i] = 0;
            }
        }
        //could not reach a desired result
        return false;
    }

    //validates the position of each queen before the current queen's row
    private boolean boardValidates(int[][] board, int col, int row, int n){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    //if queen in same column or in diagonal (using slope=1 formula)
                    if(j == col || Math.abs(i-row) == Math.abs(j-col)){
                        return false;
                    }
                }
            }
        }
        //if no queen threatens
        return true;
    }

    //method to print in matrix form
    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}