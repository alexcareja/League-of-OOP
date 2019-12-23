package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Constants;

public final class OffensiveStrategy implements Strategy {

    private static OffensiveStrategy instance;

    private OffensiveStrategy() {
    }

    public static OffensiveStrategy getInstance() {
        if (instance == null) {
            instance = new OffensiveStrategy();
        }
        return instance;
    }

    @Override
    public void applyStrategy(final Knight h) {
        h.heal(Math.round(h.getHp() * Constants.KNIGHT_OFF_HEAL));
        h.modStratModifier(Constants.KNIGHT_OFF_DMG);
    }

    @Override
    public void applyStrategy(final Pyromancer h) {
        h.heal(Math.round(h.getHp() * Constants.PYRO_OFF_HEAL));
        h.modStratModifier(Constants.PYRO_OFF_DMG);
    }

    @Override
    public void applyStrategy(final Rogue h) {
        h.heal(Math.round(h.getHp() * Constants.ROGUE_OFF_HEAL));
        h.modStratModifier(Constants.ROGUE_OFF_DMG);
    }

    @Override
    public void applyStrategy(final Wizard h) {
        h.heal(Math.round(h.getHp() * Constants.WIZARD_OFF_HEAL));
        h.modStratModifier(Constants.WIZARD_OFF_DMG);
    }
}
