package main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class GameMap {
    private static GameMap instance = null;
    private int n;
    private int m;
    private LandType[][] map;
    private Map<Hero, Integer> playersPositions;
    /*
     * Pozitiile jucatorilor sunt reprezentate pe un int astfel: x*m + y, unde m este numarul de
     * coloane, iar x si y sunt linia respectiv coloana din matricea map.(pozitia efectiva)
     * */

    private GameMap(final int n, final int m, final FileSystem fileReader) throws IOException {
        this.n = n;
        this.m = m;
        this.map = new LandType[n][m];
        for (int i = 0; i < n; i++) {    // Crearea hartii
            String line = fileReader.nextWord();
            for (int j = 0; j < m; j++) {
                switch (line.charAt(j)) {
                    case 'D':
                        this.map[i][j] = LandType.Desert;
                        break;
                    case 'L':
                        this.map[i][j] = LandType.Land;
                        break;
                    case 'V':
                        this.map[i][j] = LandType.Volcanic;
                        break;
                    case 'W':
                        this.map[i][j] = LandType.Woods;
                        break;
                    default:
                        break;
                }
            }
        }
        this.playersPositions = new HashMap<>();
    }

    static GameMap getInstance(final int n, final int m, final FileSystem fileReader)
            throws IOException {
        if (instance == null) {  // Singleton Pattern
            instance = new GameMap(n, m, fileReader);
        }
        return instance;
    }

    void placeHero(final Hero hero, final int x, final int y) {
        playersPositions.put(hero, x * this.m + y);
    }

    void moveHero(final Hero h, final char move) {
        int currentPosition = playersPositions.get(h);
        switch (move) {
            case 'R':
                playersPositions.put(h, currentPosition + 1);
                break;
            case 'L':
                playersPositions.put(h, currentPosition - 1);
                break;
            case 'U':
                playersPositions.put(h, currentPosition - this.m);
                break;
            case 'D':
                playersPositions.put(h, currentPosition + this.m);
                break;
            default:
                break;
        }
    }

    void fight() {
        Hero h1, h2;
        for (int i = 0; i < this.n * this.m; i++) {
            // Verific fiecare pozitie de pe harta si caut 2 eroi sa se lupte
            h1 = null;
            h2 = null;
            for (Hero h : playersPositions.keySet()) {
                if (i == playersPositions.get(h) && !h.isDead()) {
                    if (h1 == null) {
                        h1 = h;
                    } else {
                        h2 = h;
                        break;
                    }
                }
            }
            if (h2 == null) {    // nu s-au gasit 2 eroi
                continue;
            }
            if (h1 instanceof Wizard) {  // Wizard ataca al doilea (pentru deflect)
                Hero h3 = h1;
                h1 = h2;
                h2 = h3;
            }
            h2.takeDmg(h1, this.map[i / this.m][i % this.m]);
            h1.takeDmg(h2, this.map[i / this.m][i % this.m]);
        }
    }

    String getPos(final Hero h) {
        int heroPos = playersPositions.get(h);
        return heroPos / this.m + " " + heroPos % this.m;
    }
}
