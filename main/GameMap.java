package main;

import fileio.implementations.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GameMap {
    private int N;
    private int M;
    private char[][] map;
    private Map<Hero, Position> players_positions;

    GameMap(int N, int M, FileReader fileReader) throws IOException {
        this.N = N;
        this.M = M;
        this.map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = fileReader.nextWord();
            for(int j = 0; j < M; j++) {
                this.map[i][j] = line.charAt(j);
            }
        }
        this.players_positions = new HashMap<>();
    }

    char getTerrain(int i, int j) {
        return this.map[i][j];
    }

    void placeHero(Hero hero, int x, int y) {
        players_positions.put(hero, new Position(x, y));
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
