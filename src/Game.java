import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    char[] gamePlan = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    boolean continueGame = true;
    private Player player1;
    private Player player2;

    public Game(){

    }

    public void main(String[] args) {
        boolean someoneHasWon = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välkommen till Antons tre i rad!");
        System.out.print("Spelare ett namn: ");

        player1 = new Player(scanner.nextLine(), 'X');

        System.out.print("Spelare två namn, ange 'BOT' om du vill spela mot datorn: ");

        player2 = new Player(scanner.nextLine(), 'O');

        System.out.println(player1.Name + " du är " + player1.Symbol + ", " + player2.Name + " är " + player2.Symbol);
        System.out.println("Speldraget anges med 1-9");

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
                //checks if we should end game and if someone has won
                someoneHasWon = shouldWeEndGame();

            }
            restartGame(activePlayer, someoneHasWon);
        }
    }

    public void printGame(){
        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);
    }

    //play move
    public void makeMove(Player activePlayer){
        //BOTS MOVE
        if(Objects.equals(activePlayer.Name, "BOT")){
            Random random = new Random();
            while(true) {
                int botsMove = random.nextInt(9);
                if (gamePlan[botsMove] == 1) {
                    gamePlan[botsMove] = activePlayer.Symbol;
                    break;
                }
            }
            System.out.println("Bot har lagt sitt drag.");
        }
        //PLAYERS MOVE
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println(activePlayer.Name + ", vart vill du spela?");

            while (true) {
                int activePlayersMove;

                //input validation loop
                while (true) {
                    try {
                        System.out.print("Ange ett nummer 1 till 9: ");
                        activePlayersMove = scanner.nextInt() - 1;

                        // Check if the number is within the valid range
                        if (activePlayersMove < 0 || activePlayersMove > 8) {
                            System.out.print("Något gick fel, försök igen. ");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.print("Något gick fel, försök igen. ");
                        scanner.nextLine();
                    }
                }

                if (gamePlan[activePlayersMove] == 1) {
                    gamePlan[activePlayersMove] = activePlayer.Symbol;
                    break;
                } else {
                    System.out.println("Den platsen är redan vald. Vänligen välj en annan.");
                }
            }
        }
    }

    //checks if someone has won or all places are chosen
    public boolean shouldWeEndGame(){
        boolean someOneHasWon = false;

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
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[3] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[5] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[6] == p1Symbol && gamePlan[7] == p1Symbol && gamePlan[8] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        //checks if p1 has won vertical
        if(gamePlan[0] == p1Symbol && gamePlan[3] == p1Symbol && gamePlan[6] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[1] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[7] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[2] == p1Symbol && gamePlan[5] == p1Symbol && gamePlan[8] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        //checks if p1 has won diagonal
        if(gamePlan[0] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[8] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[2] == p1Symbol && gamePlan[4] == p1Symbol && gamePlan[6] == p1Symbol ){
            player1.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        //PLAYER TWO
        //checks if p2 has won horizontal
        if(gamePlan[0] == p2Symbol && gamePlan[1] == p2Symbol && gamePlan[2] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[3] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[5] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[6] == p2Symbol && gamePlan[7] == p2Symbol && gamePlan[8] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        //checks if p2 has won vertical
        if(gamePlan[0] == p2Symbol && gamePlan[3] == p2Symbol && gamePlan[6] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[1] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[7] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[2] == p2Symbol && gamePlan[5] == p2Symbol && gamePlan[8] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        //checks if p2 has won diagonal
        if(gamePlan[0] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[8] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }
        if(gamePlan[2] == p2Symbol && gamePlan[4] == p2Symbol && gamePlan[6] == p2Symbol ){
            player2.gamesWon++;
            continueGame = false;
            someOneHasWon = true;
        }

        return someOneHasWon;
    }

    //restart game when game over
    public void restartGame(Player activePlayer, boolean someOneHasWon){
        //print game
        printGame();
        if(someOneHasWon){
            if(Objects.equals(activePlayer.Name, "BOT")){
                System.out.println("Attans, datorn vann");
            }else {
                System.out.println("Grattis " + activePlayer.Name + "! Du vann.");
            }
        } else{
            System.out.println("Det blev oavgjort");
        }
        System.out.println();
        continueGame = true;

        System.out.println(player1.Name + "s vinster: " + player1.gamesWon);
        System.out.println(player2.Name + "s vinster: " + player2.gamesWon);
        System.out.println();
        System.out.println("Startar om spelet...");
        System.out.println();

        //resets gamePlan
        Arrays.fill(gamePlan, (char) 1);
    }
}
