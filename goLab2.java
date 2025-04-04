import java.lang.reflect.Array;
import java.util.Scanner;
public class goLab2{
    public static void main(String[] args) {
        // TODO:
        //
        Scanner scn = new Scanner(System.in);
        int moveX = 0, moveY = 0, player = 1;
        boolean validInput, playing = true;
        String tile = "0";
        String[][] goBoard = new String[9][9];
        //Everything above just sets up for later
        int p1score = 0, p2score = 0;
        while (playing) { //This loop contains the entire game, including turn switching and board printing.
            //Draw the board
            System.out.print(" ");
            for (int i = 0; i < goBoard.length; i++) {
                System.out.print(" " + i);
            }
            System.out.println("");
            for (int i = 0; i < goBoard[0].length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < goBoard.length; j++) {
                    if (goBoard[i][j] == null) {
                        if (j == 0) {
                            System.out.print("|");
                        } else {
                            System.out.print("-|");
                        }
                    } else {
                        if (j == 0) {
                            System.out.print(goBoard[i][j]);
                        } else {
                            System.out.print("-" + goBoard[i][j]);
                        }
                    }
                }
                System.out.println();
            }


            //Start of a turn and getting input
            System.out.println("player " + player + "'s turn");


            //Loop to determine if the player's input is valid
            validInput = false;
            while (validInput == false) {
                System.out.println("x coord:");
                moveX = scn.nextInt();
                System.out.println("y coord:");
                moveY = scn.nextInt();
                if (moveX < 0) {
                    validInput = false;
                } else if (moveX >= 9) {
                    validInput = false;
                } else if (moveY < 0) {
                    validInput = false;
                } else if (moveY >= 9) {
                    validInput = false;
                } //horrible icky yucky elseif chain.
                else if (goBoard[moveY][moveX] == null) {
                    validInput = true;
                }
                if (!validInput) {
                    System.out.println("Invalid position, please place your tile in an unoccupied position");
                }
            }

            //Since the input validity checker has been passed, place the piece on the board
            if (player == 1) {
                tile = "0";
            } else {
                tile = "O";
            }
            Array.set(goBoard[moveY], moveX, tile);

            //Update the scores
            /* Pseudocode: 
             * Loop through whole board, checking for each placed tile.
             * Check if a tile is surrounded on all sides (this requires more work)
             * If it is surrounded by the same color on all sides, remove it. (edges of the board are considered the opposite color)
             * 
             */


            //Then hand off the turn to the other player by changing the value of player
            if (player == 2) {
                player = 1;
            } else {
                player = 2;
            }

        }
    }
}
