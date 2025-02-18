package game;

import game.player.Player;
import io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame<BOARD, TURN> implements Game {


    private final List<Player<BOARD,TURN>> players = new ArrayList<>();
    private final Writer writer;


    private BOARD board;
    private TURN turn;
    private Player<BOARD,TURN> currentPlayer;

    protected AbstractGame(Writer writer) {
        this.writer = writer;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected void setTurn(final TURN turn) {
        this.turn = turn;
    }

    protected Player<BOARD,TURN> getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(final Player<BOARD,TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected List<Player<BOARD, TURN>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    protected BOARD getBoard() {
        return board;
    }

    protected TURN getTurn() {
        return turn;
    }

    public void addPlayer(Player<BOARD,TURN> player) {
        players.add(player);
    }

    public void removePlayer(Player<BOARD,TURN> player) {
        players.remove(player);
    }
    @Override
    public void play() {
        while (!isGameover()) {
            playRound();
        }
    }

    private void playRound() {//Integration
        for (var player : players) {
            setCurrentPlayer(player);
            playSingleTurn();
        }

    }

    private void playSingleTurn() {
        if(isGameover()) return;
        executeTurn();
        terminateTurn();

    }

    private void executeTurn() {
        do {
            turn = getCurrentPlayer().doTurn(board);
        } while(isTurnNotValid());
    }
    private boolean isTurnNotValid() {
        if(isTurnValid()) return false;
        write("Ungueltiger Zug");
        return true;
    }

    private void terminateTurn( ) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }
    private void printGameOverMessageIfGameIsOver() {
        if(isGameover()){
            write(String.format("%s hat verloren\n", getCurrentPlayer().getName()));
        }
    }

    protected void write(String message) {
        writer.write(message);
    }

    //------------- implementierungssumpf -------------

    protected abstract boolean isTurnValid() ;

    protected abstract void updateBoard() ;

    protected abstract boolean isGameover();

}
