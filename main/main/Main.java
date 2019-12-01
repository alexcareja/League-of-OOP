package main;

import fileio.FileSystem;
import heroes.Hero;
import Utils.HeroesFactory;
import map.GameMap;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        String inFile = args[0];
        String outFile = args[1];
        FileSystem fileSystem = new FileSystem(inFile, outFile);
        // Citirea din fisier
        int n = fileSystem.nextInt();
        int m = fileSystem.nextInt();
        GameMap map = GameMap.getInstance(m, n, fileSystem);
        ArrayList<Hero> heroes = new ArrayList<>();
        int noHeroes = fileSystem.nextInt();
        Hero hero;
        int x, y;
        HeroesFactory heroesFactory = HeroesFactory.getInstance();
        // Generarea eroilor
        for (int i = 0; i < noHeroes; i++) {
            String type = fileSystem.nextWord();
            hero = heroesFactory.getHeroByChar(type.charAt(0));
            heroes.add(hero);
            x = fileSystem.nextInt();
            y = fileSystem.nextInt();
            map.placeHero(hero, x, y);
        }
        int noRounds = fileSystem.nextInt();
        String moves;
        // Desfasurarea jocului
        for (int i = 0; i < noRounds; i++) {
            for (Hero h : heroes) {
                // Aplic damage overtime din runda trecuta daca exista
                if (!h.isDead()) {
                    h.applyDebuff();
                    h.checkHp();
                }
            }
            // Citeste mutarile
            moves = fileSystem.nextWord();
            int j = 0;
            char move;
            for (Hero h : heroes) {
                // Muta eroul daca nu este imobilizat
                move = moves.charAt(j++);
                if (h.isRooted() || h.isDead()) {
                    continue;
                }
                map.moveHero(h, move);
            }
            // Desfasurarea luptelor din runa curenta
            map.fight();
            // Verfica daca a murit cineva si daca trebuie facut lvl up
            for (Hero h : heroes) {
                h.checkHp();
                h.levelUp();
            }
        }
        // Scrierea in fisierul de iesire
        for (Hero h : heroes) {
            fileSystem.writeWord(h.getHeroClass());
            if (h.getHp() > 0) {
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
