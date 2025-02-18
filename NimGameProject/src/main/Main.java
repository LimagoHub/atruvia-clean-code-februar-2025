package main;

import client.GameClient;
import game.Game;
import game.nimgame.NimGameImpl;
import game.nimgame.player.ComputerPlayer;
import game.nimgame.player.HumanPlayer;
import io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        NimGameImpl game = new NimGameImpl(new ConsoleWriter());
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();
    }
}