package Utils;

import heroes.*;

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

    public Hero getHeroByChar(final char c) {
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
