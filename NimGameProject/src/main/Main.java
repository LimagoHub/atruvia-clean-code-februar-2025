package main;

import client.GameClient;
import game.Game;
import game.nimgame.NimGameImpl;

public class Main {
    public static void main(String[] args) {
        Game game = new NimGameImpl();
        GameClient client = new GameClient(game);
        client.go();
    }
}