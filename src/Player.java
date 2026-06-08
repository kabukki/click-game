/*
 * Decompiled with CFR 0.152.
 */
package click_game;

import click_game.Language;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Player
implements Serializable {
    private Set<Language> skillset = new HashSet<Language>();
    private String name;
    private long ct = 0L;
    private static final long serialVersionUID = 0L;

    public Player(String name) {
        this.name = name;
        this.load();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void save() {
        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try {
                FileOutputStream fos = new FileOutputStream("saves/" + this.name + ".dat");
                try {
                    try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
                        oos.writeObject(this);
                        System.out.println("Successfully saved " + this.name + "'s profile");
                    }
                    if (fos == null) return;
                }
                catch (Throwable throwable2) {
                    if (throwable == null) {
                        throwable = throwable2;
                    } else if (throwable != throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    if (fos == null) throw throwable;
                    fos.close();
                    throw throwable;
                }
                fos.close();
                return;
            }
            catch (Throwable throwable3) {
                if (throwable == null) {
                    throwable = throwable3;
                    throw throwable;
                } else {
                    if (throwable == throwable3) throw throwable;
                    throwable.addSuppressed(throwable3);
                }
                throw throwable;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void load() {
        try {
            Throwable throwable = null;
            Object var2_5 = null;
            try {
                FileInputStream fis = new FileInputStream("saves/" + this.name + ".dat");
                try {
                    try (ObjectInputStream ois = new ObjectInputStream(fis);){
                        Player imported = (Player)ois.readObject();
                        this.skillset = imported.skillset;
                        this.name = imported.name;
                        this.ct = imported.ct;
                    }
                    if (fis == null) return;
                }
                catch (Throwable throwable2) {
                    if (throwable == null) {
                        throwable = throwable2;
                    } else if (throwable != throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    if (fis == null) throw throwable;
                    fis.close();
                    throw throwable;
                }
                fis.close();
                return;
            }
            catch (Throwable throwable3) {
                if (throwable == null) {
                    throwable = throwable3;
                    throw throwable;
                } else {
                    if (throwable == throwable3) throw throwable;
                    throwable.addSuppressed(throwable3);
                }
                throw throwable;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("No save file found for player " + this.name);
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLanguage(Language lang) {
        this.skillset.add(lang);
    }

    public void rename(String name) {
        this.name = name;
    }

    public void click() {
        ++this.ct;
    }

    public String getSkillset() {
        return this.skillset.toString();
    }

    public long getCt() {
        return this.ct;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "(" + this.ct + ") " + this.name + " - " + this.getSkillset();
    }
}

