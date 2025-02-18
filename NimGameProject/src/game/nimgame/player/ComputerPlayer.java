package game.nimgame.player;

import java.util.logging.Logger;

public class ComputerPlayer extends AbstractNimGamePlayer{


    Logger logger = Logger.getLogger(ComputerPlayer.class.getName());
    private static final  int [] ZUEGE = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
           logger.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
        final int turn = ZUEGE[stones %4];
        System.out.printf("%s nimmt %s Steine%n",getName(),turn);
        return turn;
    }
}
