package main;

final class HeroesFactory {
    private static HeroesFactory instance = null;

    private HeroesFactory() {
    }

    static HeroesFactory getInstance() {
        if (instance == null) { // Singleton pattern
            instance = new HeroesFactory();
        }
        return instance;
    }

    Hero getHeroByChar(final char c) {
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
