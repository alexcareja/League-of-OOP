package main;

import fileio.implementations.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String file_name = args[0];
        FileReader fileReader = new FileReader(file_name);
        int N = fileReader.nextInt();
        int M = fileReader.nextInt();
        GameMap map = new GameMap(M, N, fileReader);
        map.print();
        ArrayList<Hero> heroes = new ArrayList<>();
        int no_heroes = fileReader.nextInt();
        Hero hero;
        int x, y;
        for(int i = 0; i < no_heroes; i++) {
            String type = fileReader.nextWord();
            switch (type.charAt(0)) {
                case 'W':
                    hero = new Wizard();
                    break;
                case 'P':
                    hero = new Pyromancer();
                    break;
                case 'K':
                    hero = new Knight();
                    break;
                case 'R':
                    hero = new Rogue();
                    break;
                default:
                    hero = null;
                    break;
            }
            heroes.add(hero);
            x = fileReader.nextInt();
            y = fileReader.nextInt();
            map.placeHero(hero, x, y);
        }
        int no_rounds = fileReader.nextInt();
        for(int i = 0; i < no_rounds; i++){
            /*TODO
            -take dmg from previous rounds
            -read hero movement
            -move if not immobilized or dead
            -fight
             */
        }
    }
}
