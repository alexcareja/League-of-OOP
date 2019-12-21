package utils;

import angels.Angel;
import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;

public final class AngelFactory {

    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public Angel createAngel(final String angelType) {
        switch (angelType) {
            case "DamageAngel":
                return new DamageAngel();
            case "DarkAngel":
                return new DarkAngel();
            case "Dracula":
                return new Dracula();
            case "GoodBoy":
                return new GoodBoy();
            case "LevelUpAngel":
                return new LevelUpAngel();
            case "LifeGiver":
                return new LifeGiver();
            case "SmallAngel":
                return new SmallAngel();
            case "Spawner":
                return new Spawner();
            case "TheDoomer":
                return new TheDoomer();
            case "XPAngel":
                return new XPAngel();
            default:
                return null;
        }
    }
}
