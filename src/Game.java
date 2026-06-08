/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import java.io.File;

public abstract class Game {
    public static final String savedir = "saves";
    public static final String VERSION = "0.1";
    private static int delay = 1000;

    public static void init() {
        File folder = new File(savedir);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static int getDelay() {
        return delay;
    }
}

