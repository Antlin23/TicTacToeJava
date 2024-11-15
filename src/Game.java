public class Game {
    char[] gamePlan = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    boolean continueGame = true;
    public Game(){

    }

    public void printGame(){
        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);
    }

    public void shouldWeEndGame(){
        //checks if all chars in gamePlan are chosen
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

    }
}
