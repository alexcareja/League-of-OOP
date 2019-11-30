package main;

import fileio.FileSystem;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String in_name = args[0];
        String out_name = args[1];
        FileSystem fileSystem = new FileSystem(in_name, out_name);
        int N = fileSystem.nextInt();
        int M = fileSystem.nextInt();
        GameMap map = GameMap.getInstance(M, N, fileSystem);
        ArrayList<Hero> heroes = new ArrayList<>();
        int no_heroes = fileSystem.nextInt();
        Hero hero;
        int x, y;
        HeroesFactory heroesFactory = HeroesFactory.getInstance();
        for(int i = 0; i < no_heroes; i++) {
            String type = fileSystem.nextWord();
            hero = heroesFactory.getHeroByChar(type.charAt(0));
            heroes.add(hero);
            x = fileSystem.nextInt();
            y = fileSystem.nextInt();
            map.placeHero(hero, x, y);
        }
        int no_rounds = fileSystem.nextInt();
        String moves;
        for(int i = 0; i < no_rounds; i++){
            for(Hero h:heroes) {
                if(!h.isDead()){
                    h.applyDebuff();
                    h.checkHp();
                }
            }
            moves = fileSystem.nextWord();
            int j = 0;
            char move;
            for(Hero h:heroes) {
                move = moves.charAt(j++);
                if(h.isRooted() || h.isDead()) {
                    continue;
                }
                map.moveHero(h, move);
            }
            map.fight();

            for(Hero h:heroes) {
                h.checkHp();
                h.levelUp();
            }
        }
        for(Hero h:heroes) {
            fileSystem.writeWord(h.getHeroClass());
            if(h.getHp() > 0){
                fileSystem.writeWord(h.getStatus());
                fileSystem.writeWord(map.getPos(h));
                fileSystem.writeNewLine();
                continue;
            }
            fileSystem.writeWord("dead");
            fileSystem.writeNewLine();
        }
        fileSystem.close();
    }
}
