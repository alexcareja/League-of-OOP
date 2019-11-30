package main;

import fileio.implementations.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GameMap {
    private static GameMap instance = null;
    private int N;
    private int M;
    private LandType[][] map;
    private Map<Hero, Integer> players_positions;
    /*
    * Player positions will be represented using an Integer like this: let's say a player
    * has the position (x, y), then his position will be represented as x*M +  y.
    * */

    private GameMap(int N, int M, FileReader fileReader) throws IOException {
        this.N = N;
        this.M = M;
        this.map = new LandType[N][M];
        for(int i = 0; i < N; i++) {
            String line = fileReader.nextWord();
            for(int j = 0; j < M; j++) {
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
        this.players_positions = new HashMap<>();
    }

    static GameMap getInstance(int N, int M, FileReader fileReader) throws IOException {
        if(instance == null) {
            instance = new GameMap(N, M, fileReader);
        }
        return instance;
    }

    LandType getTerrain(int i, int j) {
        return this.map[i][j];
    }

    void placeHero(Hero hero, int x, int y) {
        players_positions.put(hero, x * this.M + y);
    }

    void moveHero(Hero h, char move) {
        int currentPosition = players_positions.get(h);
        switch (move) {
            case 'R':
                players_positions.put(h, currentPosition + 1);
                break;
            case 'L':
                players_positions.put(h, currentPosition - 1);
                break;
            case 'U':
                players_positions.put(h, currentPosition - this.M);
                break;
            case 'D':
                players_positions.put(h, currentPosition + this.M);
                break;
            default:
                break;
        }
    }

    void findOpponent(Hero hero) {
        int heroPos = players_positions.get(hero);
        for(Map.Entry<Hero, Integer> entry : players_positions.entrySet()) {
            if(entry.getKey() == hero || entry.getKey().isDead()) {
                continue;
            }
            if(entry.getValue() == heroPos) {
                entry.getKey().takeDmg(hero, this.map[heroPos / this.M][heroPos % this.M]);
            }
        }
    }

    void printPos(Hero h) {
        int heroPos = players_positions.get(h);
        System.out.println(heroPos / this.M + " " + heroPos % this.M);
    }

    void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
