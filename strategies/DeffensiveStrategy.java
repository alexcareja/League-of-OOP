package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Constants;

public final class DeffensiveStrategy implements Strategy {

    private static DeffensiveStrategy instance;

    private DeffensiveStrategy() {
    }

    public static DeffensiveStrategy getInstance() {
        if (instance == null) {
            instance = new DeffensiveStrategy();
        }
        return instance;
    }

    @Override
    public void applyStrategy(final Knight h) {
        h.heal((int) Math.floor(h.getHp() * Constants.KNIGHT_DEFF_HEAL));
        h.modStratModifier(Constants.KNIGHT_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Pyromancer h) {
        h.heal((int) Math.floor(h.getHp() * Constants.PYRO_DEFF_HEAL));
        h.modStratModifier(Constants.PYRO_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Rogue h) {
        h.heal((int) Math.floor(h.getHp() * Constants.ROGUE_DEFF_HEAL));
        h.modStratModifier(Constants.ROGUE_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Wizard h) {
        h.heal((int) Math.floor(h.getHp() * Constants.WIZARD_DEFF_HEAL));
        h.modStratModifier(Constants.WIZARD_DEFF_DMG);
    }
}
