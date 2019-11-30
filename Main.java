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
        GameMap map = GameMap.getInstance(M, N, fileReader);
        ArrayList<Hero> heroes = new ArrayList<>();
        int no_heroes = fileReader.nextInt();
        Hero hero;
        int x, y;
        HeroesFactory heroesFactory = HeroesFactory.getInstance();
        for(int i = 0; i < no_heroes; i++) {
            String type = fileReader.nextWord();
            hero = heroesFactory.getHeroByChar(type.charAt(0));
            heroes.add(hero);
            x = fileReader.nextInt();
            y = fileReader.nextInt();
            map.placeHero(hero, x, y);
        }
        int no_rounds = fileReader.nextInt();
        String moves;
        for(int i = 0; i < no_rounds; i++){
            /*TODO
            -take dmg from previous rounds
            -read hero movement
            -move if not immobilized or dead
            -fight
             */
            for(Hero h:heroes) {
                if(!h.isDead()){
                    h.applyDebuff();
                    h.checkHp();
                }
            }
            moves = fileReader.nextWord();
            int j = 0;
            char move;
            for(Hero h:heroes) {
                move = moves.charAt(j++);
                if(h.isRooted() || h.isDead()) {
                    continue;
                }
                map.moveHero(h, move);
            }
            for(Hero h:heroes) {
                if(!h.isDead()) {
                    map.findOpponent(h);
                }
            }
            for(Hero h:heroes) {
                h.checkHp();
//                h.printStatus();
//                map.printPos(h);
                h.levelUp();
            }

        }
        for(Hero h:heroes) {
            h.printHeroClass();
            if(h.getHp() > 0){
                h.printStatus();
                map.printPos(h);
                continue;
            }
            System.out.println("dead");
        }
    }
}
