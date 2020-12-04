
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class GameUI {
    
    interface a {
        
    }
    
    interface b extends a {
        
    }
    
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour(7, 7, new char[]{'r', 'b'});
        int player = 1;
        game.fillTheBoard();
        game.displayBoard();
        System.out.println("Let's begin..");
        while (true) {
            System.out.println("Player " + player + "'s turn!");
            Scanner in = new Scanner(System.in);
            int c = in.nextInt();
            
            if (game.move(c, player)) break;
            player = (player == 1) ? 2: 1;
        }
    }
}
