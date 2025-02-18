package game.nimgame.player;

import game.player.AbstractPlayer;

import java.util.Random;

public class Grandma extends AbstractNimGamePlayer {


    private final Random random = new Random();

    public Grandma() {
    }

    public Grandma(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer integer) {
        final int turn = random.nextInt(6);
        System.out.println(String.format("%s nimmt %s Steine.",getName(), turn));
        return turn;
    }
}
