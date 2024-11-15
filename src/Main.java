import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();

        System.out.println("Välkommen till Antons tre i rad!");
        System.out.print("Spelare ett namn: ");

        Player player1 = new Player(scanner.nextLine(), 'X');

        System.out.print("Spelare två namn: ");
        Player player2 = new Player(scanner.nextLine(), 'O');

        System.out.println(player1.Name + " du är " + player1.Symbol + ", " + player2.Name + " är " + player2.Symbol);

        Player activePlayer = new Player("placeHolderPlayer", '2');
        activePlayer = player2;
        while(game.continueGame()){
            //change turns
            if(activePlayer == player1){
                activePlayer = player2;
            } else if(activePlayer == player2){
                activePlayer = player1;
            }

            //Print game
            game.printGame();

            System.out.println(activePlayer.Name + ", vart vill du spela? 1-9");

            Integer activePLayersMove = scanner.nextInt() - 1;

            game.gamePlan[activePLayersMove] = activePlayer.Symbol;
        }
    }
}
