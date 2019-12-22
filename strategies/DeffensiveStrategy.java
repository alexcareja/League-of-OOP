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
        h.heal(Math.round(h.getHp() * Constants.KNIGHT_DEFF_HEAL));
        h.setStratModifier(Constants.KNIGHT_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Pyromancer h) {
        h.heal(Math.round(h.getHp() * Constants.PYRO_DEFF_HEAL));
        h.setStratModifier(Constants.PYRO_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Rogue h) {
        h.heal(Math.round(h.getHp() * Constants.ROGUE_DEFF_HEAL));
        h.setStratModifier(Constants.ROGUE_DEFF_DMG);
    }

    @Override
    public void applyStrategy(final Wizard h) {
        h.heal(Math.round(h.getHp() * Constants.WIZARD_DEFF_HEAL));
        h.setStratModifier(Constants.WIZARD_DEFF_DMG);
    }
}
