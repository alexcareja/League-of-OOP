package map;

import angels.Spawner;
import strategies.DeffensiveStrategy;
import strategies.OffensiveStrategy;
import strategies.Strategy;
import utils.Constants;
import angels.Angel;
import fileio.FileSystem;
import heroes.Hero;
import heroes.Wizard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public final class GameMap extends Observable {
    private static GameMap instance = null;
    private int n;
    private int m;
    private LandType[][] map;
    private Map<Hero, Integer> playersPositions;
    private Strategy offensiveStrategy;
    private Strategy deffensiveStrategy;
    private ArrayList<Observer> observers;
    /*
     * Pozitiile jucatorilor sunt reprezentate pe un int astfel: x*m + y, unde m este numarul de
     * coloane, iar x si y sunt linia respectiv coloana din matricea map.(pozitia efectiva)
     * */

    private GameMap(final int n, final int m, final FileSystem fileReader) throws IOException {
        this.n = n;
        this.m = m;
        this.observers = new ArrayList<>();
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
        this.offensiveStrategy = OffensiveStrategy.getInstance();
        this.deffensiveStrategy = DeffensiveStrategy.getInstance();
    }

    public static GameMap getInstance(final int n, final int m, final FileSystem fileReader)
            throws IOException {
        if (instance == null) {  // Singleton Pattern
            instance = new GameMap(n, m, fileReader);
        }
        return instance;
    }

    public void placeHero(final Hero hero, final int x, final int y) {
        playersPositions.put(hero, x * this.m + y);
    }

    public void moveHero(final Hero h, final char move) {
        h.applyStrategy(offensiveStrategy, deffensiveStrategy);
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

    public void fight(final ArrayList<Hero> heroes) {
        Hero h1, h2;
        ArrayList<String> arg = new ArrayList<>();
        ArrayList<Hero> fought = new ArrayList<>();
//        for (int i = 0; i < this.n * this.m; i++) {
//            // Verific fiecare pozitie de pe harta si caut 2 eroi sa se lupte
//            h1 = null;
//            h2 = null;
//            for (Hero h : playersPositions.keySet()) {
//                if (i == playersPositions.get(h) && !h.isDead()) {
//                    if (h1 == null) {
//                        h1 = h;
//                    } else {
//                        h2 = h;
//                        break;
//                    }
//                }
//            }
        for (Hero h : heroes) {
            if (h.isDead()) {
                continue;
            }
            h1 = h;
            h2 = null;
            for (Hero h3 : heroes) {
                if (h3 == h1 || h3.isDead() || fought.contains(h3)) {
                    continue;
                }
                if (this.playersPositions.get(h1).equals(this.playersPositions.get(h3))) {
                    h2 = h3;
                    break;
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
            int pos = this.playersPositions.get(h1);
            h2.accept(h1, this.map[pos / this.m][pos % this.m]);
            h1.accept(h2, this.map[pos / this.m][pos % this.m]);
            fought.add(h1);
            fought.add(h2);
            if (h1.getHp() <= 0 && h2.getHp() > 0) {
                h2.addExpGained();
            }
            if (h2.getHp() <= 0 && h1.getHp() > 0) {
                h1.addExpGained();
            }
            if (h1.getId() < h2.getId()) {
                Hero h3 = h1;
                h1 = h2;
                h2 = h3;
            }
            if (h1.getHp() <= 0) {
                arg.add(Constants.PKILLED);
                arg.add(h1.getHeroType());
                arg.add(Integer.toString(h1.getId()));
                arg.add(h2.getHeroType());
                arg.add(Integer.toString(h2.getId()));
                this.notifyObservers(arg);
                arg.clear();
            }
            if (h2.getHp() <= 0) {
                arg.add(Constants.PKILLED);
                arg.add(h2.getHeroType());
                arg.add(Integer.toString(h2.getId()));
                arg.add(h1.getHeroType());
                arg.add(Integer.toString(h1.getId()));
                this.notifyObservers(arg);
                arg.clear();
            }
        }
    }

    public void spawnAngel(final Angel angel, final ArrayList<Hero> heroes,
                           final int x, final int y) {
        ArrayList<String> arg = new ArrayList<>();
        boolean wasAlive;
        for (Hero h : heroes) {
            wasAlive = !h.isDead();
            if (playersPositions.get(h) == x * this.m + y) {
                if ((h.isDead() && !(angel instanceof Spawner))
                        || (!h.isDead() && angel instanceof Spawner)) {
                    continue;
                }
                arg.add(angel.getAction());
                arg.add(h.getHeroType());
                arg.add(Integer.toString(h.getId()));
                angel.notifyObservers(arg);
                h.accept(angel, null);
                if (h.isDead() && wasAlive) {
                    arg.set(0, Constants.AKILLED);
                    angel.notifyObservers(arg);
                }
                arg.clear();
            }
        }
    }

    public String getPos(final Hero h) {
        int heroPos = playersPositions.get(h);
        return heroPos / this.m + " " + heroPos % this.m;
    }

    @Override
    public synchronized void addObserver(final Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(final Object arg) {
        for (Observer o : this.observers) {
            o.update(this, arg);
        }
    }
}
