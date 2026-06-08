/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import click_game.Game;
import click_game.Player;
import click_game.Window;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting app");
        Game.init();
        Window win = new Window("datgame", new Player("kabukki"));
    }
}

