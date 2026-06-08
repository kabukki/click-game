/*
 * Decompiled with CFR 0.152.
 */
package click_game;

public enum Language {
    ASM("Assembly"),
    C("C"),
    CPP("C++"),
    JAVA("Java"),
    JS("JavaScript"),
    PHP("PHP");

    private final String name;

    private Language(String name) {
        this.name = name;
    }

    public void printAll() {
        Language[] languageArray = Language.values();
        int n = languageArray.length;
        int n2 = 0;
        while (n2 < n) {
            Language tmp = languageArray[n2];
            System.out.println("- " + (Object)((Object)tmp));
            ++n2;
        }
    }

    public String toString() {
        return this.name;
    }
}

