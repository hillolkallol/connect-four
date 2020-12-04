
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class ConnectFour {
    
    char[][] board;
    char[] players;
    int row;
    int col;
    
    public ConnectFour (int r, int c, char[] players) {
        this.board = new char[r][c];
        this.players = players;
        this.row = r;
        this.col = c;
    }
    
    public void fillTheBoard () {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }
    
    public boolean move (int c, int player) {
        int r = lastAvailableRow (c);
        board[r][c] = players[player - 1];
        displayBoard ();
        if (checkWinner(r, c, player)) {
            System.out.println("Player " + player + " wins!");
            return true;
        }
        
        return false;
    }
    
    private int lastAvailableRow (int c) {
        int r = 0;
        while (r < row && board[r][c] == ' ') r++;
        r--;
        if (r < 0) {
            System.out.println("Invalid move!");
        }
        
        return r;
    }
    
    public boolean checkWinner (int r, int c, int player) {
        return checkRow (r, c, player) ||
                checkCol (r, c, player) ||
                checkDiagonal (r, c, player) ||
                checkAntiDiagonal (r, c, player);
    }
    
    private boolean checkRow(int r, int c, int player) {
        int count = 1;
        int currCol = c-1;
        
        while (currCol >= 0 && board[r][currCol] == players[player-1]) {
            currCol--;
            count++;
        }
        
        currCol = c+1;
        while (currCol < col && board[r][currCol] == players[player-1]) {
            currCol++;
            count++;
        }
        
        return count >= 4 ? true : false;
    }
    
    private boolean checkCol(int r, int c, int player) {
        if (row - r < 4) return false;
        
        int count = 1;
        int currRow = r+1;
        while (currRow < row && board[currRow][c] == players[player-1]) {
            currRow++;
            count++;
        }
        
        return count >= 4 ? true : false;
    }
    
    private boolean checkDiagonal(int r, int c, int player) {
        int count = 1;
        
        for (int currR = r + 1, currC = c + 1; currR < row && currC < col; currR++, currC++) {
            if (board[currR][currC] == players[player-1]) count++;
            else break;
        }
        
        for (int currR = r - 1, currC = c - 1; currR >= 0 && currC >= 0; currR--, currC--) {
            if (board[currR][currC] == players[player-1]) count++;
            else break;
        }
        
        return count >= 4 ? true : false;
    }
    
    private boolean checkAntiDiagonal(int r, int c, int player) {
        int count = 1;
        
        for (int currR = r + 1, currC = c - 1; currR < row && currC >= 0; currR++, currC--) {
            if (board[currR][currC] == players[player-1]) count++;
            else break;
        }
        
        for (int currR = r - 1, currC = c + 1; currR >= 0 && currC < col; currR--, currC++) {
            if (board[currR][currC] == players[player-1]) count++;
            else break;
        }
        
        return count >= 4 ? true : false;
    }
    
    public void displayBoard () {
        for (char[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}