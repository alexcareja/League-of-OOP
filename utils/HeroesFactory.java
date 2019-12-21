package utils;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class HeroesFactory {
    private static HeroesFactory instance = null;

    private HeroesFactory() {
    }

    public static HeroesFactory getInstance() {
        if (instance == null) { // Singleton pattern
            instance = new HeroesFactory();
        }
        return instance;
    }

    public Hero getHeroByChar(final char c, int id) {
        switch (c) {
            case 'W':
                return new Wizard(id);
            case 'P':
                return new Pyromancer(id);
            case 'K':
                return new Knight(id);
            case 'R':
                return new Rogue(id);
            default:
                return null;
        }
    }

}
