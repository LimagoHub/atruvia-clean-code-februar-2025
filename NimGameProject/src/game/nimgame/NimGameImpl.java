package game.nimgame;

import game.AbstractGame;
import game.Game;
import game.player.Player;
import io.Writer;

import java.util.ArrayList;
import java.util.List;

public class NimGameImpl extends AbstractGame<Integer,Integer> {








    public NimGameImpl(final Writer writer) {
      super(writer);
      setBoard(23);

    }


    @Override
    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }
    @Override
    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }  //Operation
    @Override
    protected boolean isGameover() {//Operation
        return getBoard() < 1 || getPlayers().isEmpty();
    };
}
