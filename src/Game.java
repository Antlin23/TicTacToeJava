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
}
