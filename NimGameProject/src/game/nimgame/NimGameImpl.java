package game.nimgame;

import game.Game;

import java.util.Scanner;

public class NimGameImpl implements Game {
    private final Scanner scanner= new Scanner(System.in);
    private int stones;
    private int turn;

    public NimGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
        while (!isGameover()) {
            playRound();
        }
    }

    private void playRound() {//Integration
        playSingleTurn();
        computerTurn();
    }

    private void playSingleTurn() {
        if(isGameover()) return;

        executeTurn();
        terminateTurn("Mensch");

    }

    private void executeTurn() {
        do {
            humanTurn();
        } while(isTurnNotValid());
    }

    private boolean isTurnNotValid() {
        if(isTurnValid()) return false;
        System.out.println("Ungueltiger Zug");
        return true;
    }


    private void humanTurn() {
        System.out.printf("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3!\n",stones);
        turn = scanner.nextInt();
    }

    private void computerTurn() {

        if(isGameover()) return;

        final int [] zuege = {3,1,1,2};



        turn = zuege[stones %4];
        System.out.printf("Computer nimmt %s Steine\n",turn);
        terminateTurn("Computer");
    }

    private void terminateTurn( final String player) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver(player);
    }

    private void printGameOverMessageIfGameIsOver(final String player) {
        if(isGameover()){
            System.out.printf("%s hat verloren\n", player);
        }
    }

    //------------- implementierungssumpf -------------

    private boolean isTurnValid() {
        return turn >= 1 && turn <= 3;
    }

    private void updateBoard() {
        stones-= turn;
    }  //Operation

    private boolean isGameover() {//Operation
        return stones < 1;
    };
}
