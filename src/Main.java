import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] gamePlan = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("Välkommen till Antons tre i rad!");
        System.out.print("Spelare ett namn: ");

        Player player1 = new Player(scanner.nextLine(), 'X');

        System.out.print("Spelare två namn: ");
        Player player2 = new Player(scanner.nextLine(), 'O');

        System.out.println(player1.Name + " du är " + player1.Symbol + ", " + player2.Name + " är " + player2.Symbol);

        Player activePlayer = player1;

        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);

        System.out.println(activePlayer.Name + ", vart vill du spela? 1-9");

        Integer activePLayersMove = scanner.nextInt() - 1;

        gamePlan[activePLayersMove] = activePlayer.Symbol;

        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);

        boolean continueGame = true;
        while(continueGame){
            if(true){
                
            }else{
                continueGame = false;
            }
        }
    }
}
