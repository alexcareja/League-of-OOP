package main;

import strategies.DeffensiveStrategy;
import strategies.OffensiveStrategy;
import strategies.Strategy;
import utils.Constants;
import admin.GrandWizard;
import angels.Angel;
import utils.AngelFactory;
import fileio.FileSystem;
import heroes.Hero;
import utils.HeroesFactory;
import map.GameMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        GrandWizard grandWizard = new GrandWizard(fileSystem);
        map.addObserver(grandWizard);
        AngelFactory angelFactory = AngelFactory.getInstance();
        ArrayList<Hero> heroes = new ArrayList<>();
        int noHeroes = fileSystem.nextInt();
        Hero hero;
        int x, y;
        HeroesFactory heroesFactory = HeroesFactory.getInstance();
        // Generarea eroilor
        for (int i = 0; i < noHeroes; i++) {
            String type = fileSystem.nextWord();
            hero = heroesFactory.getHeroByChar(type.charAt(0), i);
            hero.addObserver(grandWizard);
            heroes.add(hero);
            x = fileSystem.nextInt();
            y = fileSystem.nextInt();
            map.placeHero(hero, x, y);
        }
        int noRounds = fileSystem.nextInt();
        ArrayList<String> moves = new ArrayList<>();
        // Desfasurarea jocului
        for (int i = 0; i < noRounds; i++) {
            moves.add(fileSystem.nextWord());
        }
        Angel angel;
        int noAngels;
        String str, angelType;
        ArrayList<String> arg = new ArrayList<>();
        for (int i = 0; i < noRounds; i++) {
            fileSystem.writeWord("~~ Round " + (i + 1) + " ~~");
            fileSystem.writeNewLine();
            for (Hero h : heroes) {
                // Aplic damage overtime din runda trecuta daca exista
                if (!h.isDead()) {
                    h.applyDebuff();
                    h.checkHp();
                }
            }
            // Citeste mutarile
            int j = 0;
            char move;
            for (Hero h : heroes) {
                // Muta eroul daca nu este imobilizat
                move = moves.get(i).charAt(j++);
                if (h.isRooted() || h.isDead()) {
                    continue;
                }
                map.moveHero(h, move);
            }
            // Desfasurarea luptelor din runa curenta
            map.fight(heroes);
            // Verfica daca a murit cineva si daca trebuie facut lvl up
            for (Hero h : heroes) {
                h.checkHp();
                h.levelUp();
            }
            // Citeste din input Ingerii pentru runda curenta
            noAngels = fileSystem.nextInt();
            for (j = 0; j < noAngels; j++) {
                str = fileSystem.nextWord();
                List<String> ang = Arrays.asList(str.split(","));
                angelType = ang.get(0);
                x = Integer.parseInt(ang.get(1));
                y = Integer.parseInt(ang.get(2));
                angel = angelFactory.createAngel(angelType);
                angel.addObserver(grandWizard);
                arg.add(Constants.SPAWN);
                arg.add(Integer.toString(x));
                arg.add(Integer.toString(y));
                angel.notifyObservers(arg);
                arg.clear();
                map.spawnAngel(angel, heroes, x, y);
            }
            fileSystem.writeNewLine();
        }
        // Scrierea in fisierul de iesire
        fileSystem.writeWord("~~ Results ~~\n");
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
