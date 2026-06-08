# click-game

A small Java Swing clicker game I wrote in 2016. You click, a counter goes up, and an auto-clicker button keeps clicking for you. Player state (name, click count, "skillset" of languages) is serialized to `saves/<name>.dat`.

The original source was lost — this repo was reconstructed by decompiling `click-game.jar` with [CFR](https://www.benf.org/other/cfr/). Class, method, and field names are intact; a few try-with-resources blocks in `Player.save()` / `load()` came out a bit ugly and could use manual cleanup.

## Run

```sh
java -jar click-game.jar
```

Saves are written to `./saves/` relative to the working directory.

## Build from source

```sh
javac -d out src/*.java
cd out && jar cfe click-game.jar click_game.Main click_game/
```
