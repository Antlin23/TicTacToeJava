public class Game {
    char[] gamePlan = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    public Game(){

    }

    public void printGame(){
        System.out.println(gamePlan[0] + " " + gamePlan[1] + " " + gamePlan[2]);
        System.out.println(gamePlan[3] + " " + gamePlan[4] + " " + gamePlan[5]);
        System.out.println(gamePlan[6] + " " + gamePlan[7] + " " + gamePlan[8]);
    }

    public boolean continueGame(){
        //if all chars in gamePlan are chosen, return false
        for (char symbol : gamePlan){
            if(symbol == 1){
                return true;
            }
        }
        return false;
    }
}
