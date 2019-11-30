package main;

import java.util.HashMap;
import java.util.Map;

final class HeroesFactory {
    private static HeroesFactory instance = null;

    private HeroesFactory() {
    }

    static HeroesFactory getInstance() {
        if(instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    Hero getHeroByChar(char c) {

        switch (c) {
            case 'W':
                return new Wizard();
            case 'P':
                return new Pyromancer();
            case 'K':
                return new Knight();
            case 'R':
                return new Rogue();
            default:
                return null;
        }
    }

}
