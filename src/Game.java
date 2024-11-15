import java.util.Arrays;
import java.util.Scanner;

public class Game {
    char[] gamePlan = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    boolean continueGame = true;
    public Game(){

    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välkommen till Antons tre i rad!");
        System.out.print("Spelare ett namn: ");

        Player player1 = new Player(scanner.nextLine(), 'X');

        System.out.print("Spelare två namn: ");
        Player player2 = new Player(scanner.nextLine(), 'O');

        System.out.println(player1.Name + " du är " + player1.Symbol + ", " + player2.Name + " är " + player2.Symbol);

        while(true) {
            Player activePlayer = new Player("placeHolderPlayer", '2');
            activePlayer = player2;

            //each move
            while (continueGame) {
                //change turns
                if (activePlayer == player1) {
                    activePlayer = player2;
                } else if (activePlayer == player2) {
                    activePlayer = player1;
                }

                //print game
                printGame();
                //make move
                makeMove(activePlayer);
                //checks if we should end game
                shouldWeEndGame();
            }
            restartGame(activePlayer);
        }
    }

    public void printGame(){
        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);
    }

    //play move
    public void makeMove(Player activePlayer){
        Scanner scanner = new Scanner(System.in);
        System.out.println(activePlayer.Name + ", vart vill du spela? 1-9");

        Integer activePlayersMove = scanner.nextInt() - 1;

        gamePlan[activePlayersMove] = activePlayer.Symbol;
    }

    //checks if someone has won or all places are chosen
    public void shouldWeEndGame(){

        //checks if all places in gamePlan are chosen, and returns false
        boolean containsOne = false;
        for (char c : gamePlan) {
            if (c == 1) {
                containsOne = true;
                break;
            }
        }
        if(!containsOne){
            continueGame = false;
        }


        //checks if anyone has won
        char p1Symbol = 'X';
        char p2Symbol = 'O';

        //PLAYER ONE
        //checks if p1 has won horizontal
        if(gamePlan[0] == p1Symbol && gamePlan[1] == p1Symbol && gamePlan[2] == p1Symbol ){
            continueGame = false;
        }
        if(gamePlan[3] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[5] == p1Symbol ){
            continueGame = false;
        }
        if(gamePlan[6] == p1Symbol && gamePlan[7] == p1Symbol && gamePlan[8] == p1Symbol ){
            continueGame = false;
        }

        //checks if p1 has won vertical
        if(gamePlan[0] == p1Symbol && gamePlan[3] == p1Symbol && gamePlan[6] == p1Symbol ){
            continueGame = false;
        }
        if(gamePlan[1] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[7] == p1Symbol ){
            continueGame = false;
        }
        if(gamePlan[2] == p1Symbol && gamePlan[5] == p1Symbol && gamePlan[8] == p1Symbol ){
            continueGame = false;
        }

        //checks if p1 has won diagonal
        if(gamePlan[0] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[8] == p1Symbol ){
            continueGame = false;
        }
        if(gamePlan[2] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[6] == p1Symbol ){
            continueGame = false;
        }

        //PLAYER TWO
        //checks if p2 has won horizontal
        if(gamePlan[0] == p2Symbol && gamePlan[1] == p2Symbol && gamePlan[2] == p2Symbol ){
            continueGame = false;
        }
        if(gamePlan[3] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[5] == p2Symbol ){
            continueGame = false;
        }
        if(gamePlan[6] == p2Symbol && gamePlan[7] == p2Symbol && gamePlan[8] == p2Symbol ){
            continueGame = false;
        }

        //checks if p2 has won vertical
        if(gamePlan[0] == p2Symbol && gamePlan[3] == p2Symbol && gamePlan[6] == p2Symbol ){
            continueGame = false;
        }
        if(gamePlan[1] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[7] == p2Symbol ){
            continueGame = false;
        }
        if(gamePlan[2] == p2Symbol && gamePlan[5] == p2Symbol && gamePlan[8] == p2Symbol ){
            continueGame = false;
        }

        //checks if p2 has won diagonal
        if(gamePlan[0] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[8] == p2Symbol ){
            continueGame = false;
        }
        if(gamePlan[2] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[6] == p2Symbol ){
            continueGame = false;
        }
    }

    //restart game when game over
    public void restartGame(Player activePlayer){
        //print game
        printGame();
        System.out.println("Grattis " + activePlayer.Name + "! Du vann.");
        System.out.println("Startar om spelet...");
        System.out.println();
        continueGame = true;

        //resets gamePlan
        Arrays.fill(gamePlan, (char) 1);
    }
}
